package com.gmail.shinsensei.deliverablesHub.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Authorization Interceptor
 * @author Francesco Bux
 */
public class Authorization implements Interceptor {
    
    private Set allowedRoles = Collections.EMPTY_SET;
    private Set disallowedRoles = Collections.EMPTY_SET;
    private static final String ALLOWED_ROLES_PARAM_NAME = "allowedRoles";
    private static final String DISALLOWED_ROLES_PARAM_NAME = "disallowedRoles";
    public static final String NO_ROLE = "NO_ROLE";
    private static final String AUTHORIZARION_REQUIRED = "authorization_required";

    
    public Authorization() {
    }
    
    @Override
    public void destroy() {
        System.out.println("Authorization Interceptor Destroyed");
    }
    
    @Override
    public void init() {
        System.out.println("Authorization Interceptor Started");
    }
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        final String actionName = invocation.getProxy().getActionName();
        Map session = invocation.getInvocationContext().getSession();
        Object userRole = session.containsKey(com.gmail.shinsensei.deliverablesHub.actions.Auth.ROLE_TOKEN) ? session.get(com.gmail.shinsensei.deliverablesHub.actions.Auth.ROLE_TOKEN) : Authorization.NO_ROLE;
        return (hasSufficientRole((String)userRole)) ? invocation.invoke() : Authorization.AUTHORIZARION_REQUIRED;
    }
    
    public boolean hasSufficientRole(String userRole) {  
        userRole = userRole.toLowerCase();
        if(this.disallowedRoles.contains("*"))
            return false;
        if(this.disallowedRoles.contains(userRole))
            return false;
        if(this.allowedRoles.contains("*"))
            return true;
        if(this.allowedRoles.contains(userRole))
            return true;
        
        return false;
    }
    
    static boolean hasSufficientRole(Set allowedRoles, Set disallowedRoles, String userRole)
    {
        userRole = userRole.toLowerCase();
        
        if(disallowedRoles != null && (disallowedRoles.contains("*") || disallowedRoles.contains(userRole)))
            return false;
        
        if(allowedRoles != null && (allowedRoles.contains("*") || allowedRoles.contains(userRole)))
            return true;
        
        return false;
    }
    
    /**
     * Use * to refer all roles. Parameters are allowedRoles and disallowedRoles, all comma separated
     * @param parameters 
     */
    public void setAllowedRoles(String allowedRoles)
    {
        if(allowedRoles != null)
            this.allowedRoles = TextParseUtil.commaDelimitedStringToSet(allowedRoles);
    }
    
    public void setDisallowedRoles(String disallowedRoles)
    {
        if(disallowedRoles != null)
            this.disallowedRoles = TextParseUtil.commaDelimitedStringToSet(disallowedRoles);
    }
    
}
