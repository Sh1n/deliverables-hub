package com.gmail.shinsensei.deliverablesHub.actions;

import com.gmail.shinsensei.deliverablesHub.logic.AuthRemote;
import com.gmail.shinsensei.deliverablesHub.utils.SecurityUtils;
import com.gmail.shinsensei.deliverablesHub.utils.ServiceLocator;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;


import com.opensymphony.xwork2.Action;


/**
 * Action class for auth namespace
 * @author Francesco Bux
 */
public class Auth extends ControllerBase{
    
    AuthRemote auth = ServiceLocator.lookupAuthRemote();
    
    
    public final static String LOGGED_TOKEN = "logged_token";
    public final static String ROLE_TOKEN = "role_token";
    public final static String SYSTEM_ID = "userID";
    
    private String username;
    private String password;
    private String email;
    
    
    // inserire validazione con annotazioni
    /**
     * richiesti email e password
     * @return 
     */
    public String login(){
        if(this.getFormSubmit() != null){
            if((this.getEmail() != null && !this.getEmail().equals("")) && (this.getPassword() != null && !this.getPassword().equals(""))) 
                try{
                    SystemUserTO user = new SystemUserTO(this.getEmail(), SecurityUtils.hashPassword(this.getPassword()));
                    System.out.println(user.getPassword());
                    if((user = auth.login(user)) != null)
                    {
                        session.put(Auth.LOGGED_TOKEN, true);
                        session.put(Auth.SYSTEM_ID, user.getUserId());
                        session.put(Auth.ROLE_TOKEN, user.getType().toString().toLowerCase());
                        return Action.SUCCESS;
                    }else
                       this.addActionError(this.getText("errors.login_not_valid"));
                    return Action.ERROR;
                }catch(Exception Ex){
                    System.err.println(Ex.getMessage());
                }
            else
                this.addActionError(this.getText("errors.data_missing"));
        }
        return Action.INPUT;
    } 
    
    
    public String logout(){ 
        if(session.containsKey(Auth.LOGGED_TOKEN)){
            session.remove(Auth.LOGGED_TOKEN);
            session.remove(Auth.ROLE_TOKEN);
            return Action.SUCCESS;
        }
        return Action.ERROR; 
    }
    
    /**
     * Getters & Setters
     */
    public String getUsername(){ return this.username; }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){ return this.password; }
    public void setPassword(String password){ 
        this.password = password;
    }
    
    public String getEmail(){ return this.email; }
    public void setEmail(String email){ 
        this.email = email;
    }

   


}
