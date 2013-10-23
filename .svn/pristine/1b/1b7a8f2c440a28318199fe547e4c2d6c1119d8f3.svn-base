package com.gmail.shinsensei.deliverablesHub.interceptors;
import java.util.Map;
import java.util.Set;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;
import java.util.Collections;

/**
 * Authentication Interceptor
 * @author Francesco Bux
 */
public class Authentication implements Interceptor {
    
    public static String AUTHENTICATION_REQUIRED = "authentication_required";
    public static String EXCLUDED_ACTIONS_FIELD = "excluded_actions";
    private Set excluded_actions = Collections.EMPTY_SET;
    
    public Authentication() {
    }
    
    @Override
    public void destroy() {
        System.out.println("Authentication Interceptor Destroyed");
    }
    
    @Override
    public void init() {
        System.out.println("Authentication Interceptor Started");
    }
    
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map session = actionInvocation.getInvocationContext().getSession();
        String actionName = actionInvocation.getProxy().getNamespace() + "/" + actionInvocation.getProxy().getActionName();
        
        session.put("namespace", actionInvocation.getProxy().getNamespace());
        session.put("action", actionInvocation.getProxy().getActionName());
        
        Object authentication_token = session.get(com.gmail.shinsensei.deliverablesHub.actions.Auth.LOGGED_TOKEN);
        return (this.excluded_actions.contains(actionName) || (authentication_token != null && authentication_token instanceof Boolean && authentication_token.equals(Boolean.TRUE))) ? actionInvocation.invoke() : Authentication.AUTHENTICATION_REQUIRED;
    }
    
    public void setExcludedActions(String excludedActions){
        if(excludedActions != null)
            this.excluded_actions = TextParseUtil.commaDelimitedStringToSet(excludedActions);
    }
}
