package com.gmail.shinsensei.deliverablesHub.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author Francesco Bux
 */
public class ControllerBase extends ActionSupport implements ServletContextAware, SessionAware, ServletRequestAware, ServletResponseAware {
 
    protected ServletContext context = null;
    
    protected String formSubmit = null;

    public String getFormSubmit() {
        return formSubmit;
    }

    public void setFormSubmit(String formSubmit) {
        this.formSubmit = formSubmit;
    }
    
    
    protected Map<String, Object> session = null;
    protected HttpServletRequest request = null;
    protected HttpServletResponse response = null;
 
    @Override
    public void setServletContext(ServletContext context) {
        this.context = context;
    }
 
    @Override
    public void setSession(Map<String, Object> session) {
        System.out.println("Session AWARE");
        this.session = session;
    }
 
    @Override
    public void setServletRequest(HttpServletRequest request) {
        System.out.println("Request Aware");
        this.request = request;
    }
 
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    
    private Map<String, Object> parameters;
    
    public ControllerBase(){
        this.parameters = ActionContext.getContext().getParameters();
        this.session = ActionContext.getContext().getSession();
    //    this.request = null;
    }
    
    protected Map<String, Object> jsonResponse = new HashMap<String, Object>();

    public Map<String, Object> getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(Map<String, Object> jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
    
    protected boolean isXHR(){
        return this.request.getHeader("X-Requested-With").equals("XMLHttpRequest");
    }
    
    protected boolean isPOST(){
        return this.request.getMethod().equals("POST");
    }
    
    protected boolean isGET(){
        return this.request.getMethod().equals("GET");
    }
    
    protected void setSessionVar(String key, Object value){
        this.session.put(key, value);
    }
    
    protected Object getSessionVar(String key){
        if(this.session.containsKey(key))
            return this.session.get(key);
        return null;
    }
}
