/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.gmail.shinsensei.deliverablesHub.actions.Auth;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * This interceptor simply loads the menu items and prepare them to be displayed.
 * It requires a particular java class.
 * This is a default interceptor, it means that it's used before every action. 
 * The init method is called only once, at struts loading time, this means that
 * it is impossible, with the current configuration, obtain access level at load time.
 * One way to avoid this is to instantiate the interceptor for every action, and after
 * the Authorization and Authentication ones, this because the intercept method is capable of 
 * reading session vars. 
 * 
 * Hint : the intercept method will be always called, this means that the init method loads 
 * all the menu item, while the intercept method will remove from these the ones that cannot be accessed.
 * 
 * The problem is that the interceptor is used by all user connected so the menu_item 
 * cannot be modified once, but those computation must be done after each request, hence
 * the intercept method will do the computation and assign the proper menu to the session variable
 * used.
 * It is necessary to configure this interceptor after the authorization one.
 * 
 * How to manage permission ? 
 * We can store, for each action, the list of both allowed and disallowed roles and leave to the 
 * authorization interceptor the logic to decide if its available or not.
 * This interceptor will flag each item menu has viewable or not on the base of authorization interceptor's result.
 * 
 * @author Francesco Bux
 * @version 1.0
 */
public class MenuBuilder implements Interceptor {
    
    /**
     * Menu_items = array(
     *  packageName => array(
     *      nameSpace => "/namespace",
     *      elements => array(
     *          "action" => array(
     *              "allowed"       =>  allowed roles,
     *              "disallowed"    =>  dsallowed roles,
     *          )
     *          ...
     *      )
     *  )
     *  ...
     * ) 
     *      
     */
    private HashMap menu_items = new HashMap();
    
    private static final String VIEWABLE = "viewable";
    private static final String ELEMENTS = "elements";
    private static final String ALLOWED  = "allowed";
    private static final String DISALLOWED = "disallowed";
    
    public MenuBuilder() {
    }
    
    public void destroy() {
        System.out.println("Menu Builder Interceptor Destroyed");
    }
    
    public void init() {
        System.out.println("Menu Builder Interceptor Created");
        try{
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
           // domFactory.setNamespaceAware(true);
            
      //      Document doc = domFactory.newDocumentBuilder().parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("struts.xml"));
            Document doc = domFactory.newDocumentBuilder().parse(this.getClass().getClassLoader().getResourceAsStream("struts.xml"));
            XPath xpath = XPathFactory.newInstance().newXPath();
            Object result = xpath.compile("//package").evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            if(nodes.getLength() > 0){
                for (int i = 0; i < nodes.getLength(); i++)
                {
                    String packageName = nodes.item(i).getAttributes().getNamedItem("name").getTextContent();
                    if(!packageName.equals("default") && !packageName.equals("errors") && !packageName.equals("auth"))
                    {
                        String namespace = nodes.item(i).getAttributes().getNamedItem("namespace").getTextContent();
                        HashMap pack = new HashMap();   // generic information about a package
                        HashMap items = new HashMap();  // information about li elements
                        pack.put("namespace", namespace);
                        // iterate over actions -> menu items
                        NodeList actions = nodes.item(i).getChildNodes();
                        for(int j = 0; j < actions.getLength(); j++)
                        {
                            Node action = actions.item(j);
                            if (action.getNodeType() == Node.ELEMENT_NODE) {
                                String actionName = action.getAttributes().getNamedItem("name").getTextContent();
                                
                                // Permissions          
                                NodeList allowedRoles = (NodeList) xpath.evaluate("//package[@name='" + packageName + "']/action[@name='" + actionName + "']//param[@name='allowedRoles']", doc, XPathConstants.NODESET);
                                NodeList disallowedRoles = (NodeList) xpath.evaluate("//package[@name='" + packageName + "']/action[@name='" + actionName + "']//param[@name='disallowedRoles']", doc, XPathConstants.NODESET);
                                HashMap rolesResult = new HashMap();
                                // La gestione dei permessi è affidata agli intercettori
                                 
                                if(allowedRoles.getLength() > 0)
                                    rolesResult.put("allowed", TextParseUtil.commaDelimitedStringToSet(allowedRoles.item(0).getTextContent()));
                                if(disallowedRoles.getLength() > 0)
                                    rolesResult.put("disallowed", TextParseUtil.commaDelimitedStringToSet(disallowedRoles.item(0).getTextContent()));
                                
                                items.put(actionName, rolesResult);
                            }
                        }
                        pack.put("elements", items);
                        this.menu_items.put(packageName, pack);
                    }
                }
            }
            NodeList included = (NodeList) xpath.compile("//include").evaluate(doc, XPathConstants.NODESET);
            if(included.getLength() > 0){
                for (int i = 0; i < included.getLength(); i++)
                {
                    String fileName = included.item(i).getAttributes().getNamedItem("file").getTextContent();
                    Document subDoc = domFactory.newDocumentBuilder().parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
                    XPath subXpath = XPathFactory.newInstance().newXPath();
                    NodeList subNodes = (NodeList) subXpath.compile("//package").evaluate(subDoc, XPathConstants.NODESET);
                    if(subNodes.getLength() > 0){
                        for (int j = 0; j < subNodes.getLength(); j++)
                        {
                            String packageName = subNodes.item(j).getAttributes().getNamedItem("name").getTextContent();
                            if(!packageName.equals("default") && !packageName.equals("errors") && !packageName.equals("auth"))
                            {
                                String namespace = subNodes.item(j).getAttributes().getNamedItem("namespace").getTextContent();
                                HashMap pack = new HashMap();   // generic information about a package
                                HashMap items = new HashMap();  // information about li elements
                                pack.put("namespace", namespace);
                                // iterate over actions -> menu items
                                NodeList actions = subNodes.item(j).getChildNodes();
                                for(int k = 0; k < actions.getLength(); k++)
                                {
                                    Node action = actions.item(k);
                                    if (action.getNodeType() == Node.ELEMENT_NODE) {
                                        String[] tmp = action.getAttributes().getNamedItem("name").getTextContent().split("/");
                                        String actionName = tmp[0];
                                        //String actionName = action.getAttributes().getNamedItem("name").getTextContent();

                                        // Permissions          
                                        NodeList allowedRoles = (NodeList) xpath.evaluate("//package[@name='" + packageName + "']/action[@name='" + actionName + "']//param[@name='allowedRoles']", subDoc, XPathConstants.NODESET);
                                        NodeList disallowedRoles = (NodeList) xpath.evaluate("//package[@name='" + packageName + "']/action[@name='" + actionName + "']//param[@name='disallowedRoles']", subDoc, XPathConstants.NODESET);
                                        HashMap rolesResult = new HashMap();
                                        // La gestione dei permessi è affidata agli intercettori

                                        if(allowedRoles.getLength() > 0)
                                            rolesResult.put("allowed", TextParseUtil.commaDelimitedStringToSet(allowedRoles.item(0).getTextContent()));
                                        if(disallowedRoles.getLength() > 0)
                                            rolesResult.put("disallowed", TextParseUtil.commaDelimitedStringToSet(disallowedRoles.item(0).getTextContent()));

                                        items.put(actionName, rolesResult);
                                    }
                                }
                                pack.put("elements", items);
                                this.menu_items.put(packageName, pack);
                            }
                        }
                    }
                }
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        
        boolean logged = actionInvocation.getInvocationContext().getSession().containsKey(Auth.LOGGED_TOKEN) ? (Boolean) actionInvocation.getInvocationContext().getSession().get(Auth.LOGGED_TOKEN) : false;
        String role = actionInvocation.getInvocationContext().getSession().containsKey(Auth.ROLE_TOKEN) ? (String) actionInvocation.getInvocationContext().getSession().get(Auth.ROLE_TOKEN) : Authorization.NO_ROLE;
        
        HashMap instantiatedMenu = new HashMap(this.menu_items);
        Collection packages = instantiatedMenu.values();
        Iterator packagesIterator = instantiatedMenu.values().iterator();
        while(packagesIterator.hasNext()){  // for each package
            HashMap packageMap = (HashMap) packagesIterator.next();
            Iterator actionIterator =  ((HashMap) packageMap.get("elements")).values().iterator();
            int viewableCount = 0;          // if the viewable actions are 0, the package is removed from the list
            while(actionIterator.hasNext()){ // foreach action
                HashMap action = (HashMap) actionIterator.next();
                boolean flag = Authorization.hasSufficientRole((Set) action.get(MenuBuilder.ALLOWED), (Set)action.get(MenuBuilder.DISALLOWED), role);
                if(flag) viewableCount++;
                action.put(MenuBuilder.VIEWABLE, flag);
            }
            if(viewableCount == 0)
                packagesIterator.remove();
            viewableCount = 0;
        }
        actionInvocation.getInvocationContext().getSession().put("menu_items", instantiatedMenu);
        return actionInvocation.invoke();
    }
}
