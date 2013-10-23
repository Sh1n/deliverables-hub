package com.gmail.shinsensei.deliverablesHub.utils;

import com.gmail.shinsensei.deliverablesHub.logic.AuthRemote;
import com.gmail.shinsensei.deliverablesHub.logic.CoursesFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.logic.ProfessorsFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.logic.StudentsFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.logic.TeamsFacadeRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *  Used to retrieve beans
 * @author Francesco Bux
 */
public class ServiceLocator {
    
    private static final String JNDI_LEVEL = "java:global/";
    private static final String APP_NAME = "com.gmail.shinsensei_DeliverablesHub-ear_ear_1.3-SNAPSHOT/";
    private static final String MODULE_NAME = "DeliverablesHub-ejb-1.0-SNAPSHOT/";
    
          // pattern  java:global[/<app-name>]/<module-name>/<bean-name>[!<fully-quali-fied-interface-name>]
            
    
    private ServiceLocator(){}
    
    static{
        try{
            cxt = new InitialContext();
            active = true;
        } catch (NamingException ne) {
            DHLogger.severe("Exception caught when sgtarting service locator: " + ne.getMessage());
            active = false;
        }
    }
    
    private static boolean active;
    
    private static Context cxt;
    
    public static AuthRemote lookupAuthRemote() {
        return (AuthRemote) lookup("Auth");
    }
    
    
    public static CoursesFacadeRemote lookupCoursesFacadeRemote() {
        return (CoursesFacadeRemote) lookup("CoursesFacade");
    }
    
    public static ProfessorsFacadeRemote lookupProfessorsFacadeRemote() {
        return (ProfessorsFacadeRemote) lookup("ProfessorsFacade");
    }
    
    public static StudentsFacadeRemote lookupStudentsFacadeRemote() {
        return (StudentsFacadeRemote) lookup("StudentsFacade");
    }
    
    public static TeamsFacadeRemote lookupTeamsFacadeRemote(){
        return (TeamsFacadeRemote) lookup("TeamsFacade");
    }
    
    private static Object lookup(String name){
        if(!active)
            return null;
        try{
            return cxt.lookup(JNDI_LEVEL + APP_NAME + MODULE_NAME + name);
        }catch(NamingException ex){
            System.err.println("Exception caught at object lookup : " + ex.getMessage());
            return null;
        }
    }
}
