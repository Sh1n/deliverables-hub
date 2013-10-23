/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.SystemUser;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Francesco Bux
 */
public class SystemUserTO implements Serializable{
    
    protected final int userId;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public SystemUserType getType() {
        return type;
    }


    public int getUserId() {
        return userId;
    }

    protected final String password;
    protected final String email;
    protected final Date registrationDate;
    protected final SystemUserType type;
    
    public SystemUserTO(){
        this.userId = -1;
        this.registrationDate = null;
        this.password = "";
        this.email = "";
        this.type = SystemUserType.NOTYPE;
    }
  
    public SystemUserTO(int userId){
        this.userId = userId;
        this.registrationDate = null;
        this.password = "";
        this.email = "";
        this.type = SystemUserType.NOTYPE;
    }
    
    /**
     * Used for login data transmission -> input
     * @param email
     * @param password 
     */
    public SystemUserTO(String email, String password){
        this.userId = -1;
        this.registrationDate = null;
        this.password = password;
        this.email = email;
        this.type = SystemUserType.NOTYPE;
    }
    
    public SystemUserTO(String email, String password, SystemUserType type){
        this.userId = -1;
        this.registrationDate = null;
        this.password = password;
        this.email = email;
        this.type = type;
    }
    
    public SystemUserTO(SystemUser s){
        this.userId = s.getUserId();
        this.registrationDate = s.getRegistrationDate();
        this.password = s.getPassword();
        this.email = s.getEmail();
        this.type = SystemUserType.lookup("admin");
    }
    
    /**
     * Used for output from login method
     * @param userId
     * @param userName
     * @param password
     * @param eMail
     * @param registrationDate
     * @param type 
     */
    public SystemUserTO(int userId, String userName, String password, String eMail, Date registrationDate, SystemUserType type){
        this.userId = userId;
        this.password = password;
        this.email = eMail;
        this.registrationDate = registrationDate;
        this.type = type;
    }
    
    public SystemUserTO(SystemUserTO systemUser){
        this.userId = systemUser.getUserId();
        this.password = systemUser.getPassword();
        this.email = systemUser.getEmail();
        this.registrationDate = systemUser.getRegistrationDate();
        this.type = systemUser.getType();
    }
    
   
    
    public SystemUserTO(int userId, String userName, String password, String eMail, SystemUserType type){
        this.userId = userId;
        this.password = password;
        this.email = eMail;
        this.registrationDate = null;
        this.type = type;
    }
    
    public SystemUserTO getSystemUserTO(){
        return this;
    }
    
    public String toString() {
        return "SystemUserTO{" + "userId=" + userId + ", password=" + password + ", email=" + email + ", registrationDate=" + registrationDate + ", type=" + type + '}';
    }
    
}
