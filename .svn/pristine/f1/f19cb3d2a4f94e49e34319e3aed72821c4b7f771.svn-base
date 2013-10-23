package com.gmail.shinsensei.deliverablesHub.actions;

import com.gmail.shinsensei.deliverablesHub.logic.ProfessorsFacadeRemote;
import com.opensymphony.xwork2.Action;
//import deliverablesHub.logic.ProfessorsRemote;
import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProfessorTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserType;
import com.gmail.shinsensei.deliverablesHub.utils.SecurityUtils;
import com.gmail.shinsensei.deliverablesHub.utils.ServiceLocator;

import java.util.List;

/**
 * Professors' Action Class
 * 
 * @author Francesco Bux
 */
public class Professors extends ControllerBase{
    
    
    ProfessorsFacadeRemote professors = ServiceLocator.lookupProfessorsFacadeRemote();
    
    
    private List<ProfessorTO> professorList;
    private List<CourseTO> coursesHeld;

    public List<CourseTO> getCoursesHeld() {
        return coursesHeld;
    }

    public void setCoursesHeld(List<CourseTO> coursesHeld) {
        this.coursesHeld = coursesHeld;
    }
    
    private int professorId;
    
    private ProfessorTO newProfessor = null;
    private ProfessorTO professor = null;
    private String firstName;

    public ProfessorTO getProfessor() {
        return professor;
    }
    public void setProfessor(ProfessorTO professor) {
        this.professor = professor;
    }
    public int getProfessorId() {
        return professorId;
    }
    
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
    public ProfessorTO getNewProfessor() {
        return newProfessor;
    }
    public void setNewProfessor(ProfessorTO newProfessor) {
        this.newProfessor = newProfessor;
    }
    public List getProfessorList() {
        return professorList;
    }
    public void setProfessorList(List professorList) {
        this.professorList = professorList;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String lastName;
    public String getLastName() {
        return lastName;
    }
    private String addProfessor = null;
    public String getAddProfessor() {
        return addProfessor;
    }
    public void setAddProfessor(String addProfessor) {
        this.addProfessor = addProfessor;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    private String emailAddress;
    
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Professors() {
    }
    private String addMessage;

    /**
     * Get the value of addMessage
     *
     * @return the value of addMessage
     */
    public String getAddMessage() {
        return addMessage;
    }

    /**
     * Set the value of addMessage
     *
     * @param addMessage new value of addMessage
     */
    public void setAddMessage(String addMessage) {
        this.addMessage = addMessage;
    }

    /**
     * admin only
     * @return 
     */
    public String add_professor(){
        System.out.println("Action.professors.add with " + this);
        if(this.getFormSubmit() != null && !this.getEmailAddress().isEmpty() && !this.getFirstName().isEmpty() && !this.getLastName().isEmpty())
        {
            System.out.println("Form Submitted : " + this.getEmailAddress() + this.getFirstName() + this.getLastName());
            String password = SecurityUtils.generateRandomString(10);
            ProfessorTO newProf = new ProfessorTO(this.getFirstName(), this.getLastName(), new SystemUserTO(this.getEmailAddress(), password, SystemUserType.PROFESSOR));
            if((newProf = this.professors.addProfessor(newProf)) != null){
                this.setNewProfessor(newProf);
                this.jsonResponse.put("status", AjaxAction.SUCCESS);
                this.jsonResponse.put("responseMessage", "Professor Added Correctly");
                
                this.jsonResponse.put("newProfessor", newProf);
                return AjaxAction.SUCCESS;
            }else{
                
                this.jsonResponse.put("status", AjaxAction.ERROR);
                this.jsonResponse.put("responseMessage", "Error adding professor");
                return AjaxAction.ERROR; 
            }
        }else{
            System.out.println("Data not submitted");
            this.jsonResponse.put("status", AjaxAction.INPUT);
            this.jsonResponse.put("responseMessage", "Data not submitted");
            return AjaxAction.INPUT; 
        }
    }

    @Override
    public String toString() {
        return "Professors{" + "professorId=" + professorId + ", professor=" + professor + ", firstName=" + firstName + ", lastName=" + lastName + ", addProfessor=" + addProfessor + ", emailAddress=" + emailAddress + ", addMessage=" + addMessage + '}';
    }
    
    
    /**
     * Admin only or
     * professor id == userid
     * @return 
     */
    public String edit_professor(){
        System.out.println("Action.professors.add with " + this);
        if(this.getSessionVar(Auth.ROLE_TOKEN).equals("professor") && this.getProfessorId() != this.getSessionVar(Auth.SYSTEM_ID)){
            this.jsonResponse.put("status", AjaxAction.SUCCESS);
            this.jsonResponse.put("responseMessage", "You cannot edit another profile");
            return AjaxAction.ERROR;
        }
        
        if(this.getEmailAddress() != null && this.getFirstName() != null && this.getLastName() != null && this.getProfessorId() > 0)
        {
            System.out.println("Form Submitted : " + this.getEmailAddress() + this.getFirstName() + this.getLastName());
            // ritorna un JSON object codificato
            SystemUserTO user = new SystemUserTO(this.getProfessorId(), "", "", this.getEmailAddress(), null, SystemUserType.PROFESSOR);
            ProfessorTO newProf = new ProfessorTO(this.getFirstName(), this.getLastName(), user);
            if(this.professors.editProfessor(newProf)){
                this.setNewProfessor(newProf);
                this.jsonResponse.put("status", AjaxAction.SUCCESS);
                this.jsonResponse.put("responseMessage", "Professor Edited Correctly");
                this.jsonResponse.put("newProfessor", newProf);
                return AjaxAction.SUCCESS;
            }else{
                this.jsonResponse.put("status", AjaxAction.ERROR);
                this.jsonResponse.put("responseMessage", "Error editing professor");
                return AjaxAction.ERROR; 
            }
        }else{
            System.out.println("Data not submitted");
            this.jsonResponse.put("status", AjaxAction.INPUT);
            this.jsonResponse.put("responseMessage", "Data not submitted");
            return AjaxAction.INPUT; 
        }
    }
    
    /**
     * Retrieve details about a professor
     * @return 
     */
    public String details(){
        this.setProfessorId(22);
        System.out.println("Action Professors.details called with " + this.getProfessorId());
        // EXTRATORDINARY, should return to AJAX Version
        if(this.getFormSubmit() != null){
            if(this.getEmailAddress() != null && this.getFirstName() != null && this.getLastName() != null && this.getProfessorId() > 0)
            {
                System.out.println("Form Submitted : " + this);
                // ritorna un JSON object codificato
                SystemUserTO user = new SystemUserTO(this.getProfessorId(), "", "", this.getEmailAddress(), null, SystemUserType.PROFESSOR);
                ProfessorTO newProf = new ProfessorTO(this.getFirstName(), this.getLastName(), user);
                if(this.professors.editProfessor(newProf)){
                    this.addActionMessage("Professor edited correctly");
                }else{
                    this.addActionError("Errors modifying professor");
                }
            }else{
                this.addActionError("Input missing");
            }
        }
        
        
        ProfessorTO prof = this.professors.getProfessorById(this.getProfessorId());
        List<CourseTO> courses = this.professors.coursesHeld(this.getProfessorId());
        this.setCoursesHeld(courses);
        this.setProfessor(prof);
        return Action.SUCCESS;
    }
   
    public String courses_held(){
        List<CourseTO> coursesHeld = this.professors.coursesHeld(this.getProfessorId());
        this.jsonResponse.put("status", AjaxAction.SUCCESS);
        this.jsonResponse.put("responseMessage", "Courses List");
        this.jsonResponse.put("coursesHeld", coursesHeld);
        return AjaxAction.SUCCESS;
    }
    
    /**
     * Ritorna la lista dei professori
     * @return 
     */
    public String list_professors(){
        // EXTRAORDINARY
        if(this.getFormSubmit() != null){
            if(!this.getEmailAddress().isEmpty() && !this.getFirstName().isEmpty() && !this.getLastName().isEmpty())
            {
                System.out.println("Form Submitted : " + this);
                String password = SecurityUtils.generateRandomString(10);
                ProfessorTO newProf = new ProfessorTO(this.getFirstName(), this.getLastName(), new SystemUserTO(this.getEmailAddress(), password, SystemUserType.PROFESSOR));
                if((newProf = this.professors.addProfessor(newProf)) != null){
                    this.addActionMessage("Professor Added Correctly");
                }else{
                    this.addActionError("Professor not added");
                }
            }else{
                this.addActionError("Input needed");
            }
        }
        List<ProfessorTO> profs = this.professors.getProfessorsList();
        System.out.println(profs.toString());
        if(profs != null){
            this.setProfessorList(profs);
            return Action.SUCCESS;
        }
        return Action.SUCCESS;
    }
}
