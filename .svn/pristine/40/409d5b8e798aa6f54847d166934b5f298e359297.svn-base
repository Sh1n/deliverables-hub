package com.gmail.shinsensei.deliverablesHub.actions;

import com.gmail.shinsensei.deliverablesHub.logic.StudentsFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.utils.DHLogger;
import com.gmail.shinsensei.deliverablesHub.utils.ServiceLocator;
import com.gmail.shinsensei.deliverablesHub.utils.to.PersonTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import com.opensymphony.xwork2.Action;
/**
 * Action class for students package
 * @author Francesco Bux
 */
public class Students extends ControllerBase{
    StudentsFacadeRemote students = ServiceLocator.lookupStudentsFacadeRemote();
    
    public Students() {
       this.setSessionVar("submission", false);
    }
    
    public String signup(){ 
        DHLogger.info("Student.signup called");
        System.out.println(this.toString());
        if(this.getFormSubmit() != null && (Boolean)this.getSessionVar("submission") == false ){
            if(this.getEmail() != null && this.getPassword() != null && this.getFirstName() != null && this.getLastName() != null && this.getImmatriculationNumber() != null){
                StudentTO student = new StudentTO(new PersonTO(new SystemUserTO(this.getEmail(), this.getPassword()), this.getFirstName(), this.getLastName()), Integer.parseInt(this.getImmatriculationNumber()));
                if(this.students.addStudent(student) != null){
                    DHLogger.info("Student successfully added");
                    this.setSessionVar("submission", true);
                    return Action.SUCCESS;
                }else
                    return Action.INPUT;
            }
        }
        return Action.INPUT;
    }
    
    public String details(){
        DHLogger.info("Student.details called with student id " + this.getStudentId());
        if(this.getStudentId() > 0){
            this.setStudent(this.students.getStudentById(this.getStudentId()));
            return Action.SUCCESS;
        }
        DHLogger.severe("Wrong student id passed");
        return Action.INPUT;
    }
    
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int studentId;

    public StudentTO getStudent() {
        return student;
    }

    public void setStudent(StudentTO student) {
        this.student = student;
    }
    private StudentTO student;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    private String immatriculationNumber;

    @Override
    public String toString() {
        return "Students{" + "username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", immatriculationNumber=" + immatriculationNumber + '}';
    }

    /**
     * Get the value of immatriculationNumber
     *
     * @return the value of immatriculationNumber
     */
    public String getImmatriculationNumber() {
        return immatriculationNumber;
    }

    /**
     * Set the value of immatriculationNumber
     *
     * @param immatriculationNumber new value of immatriculationNumber
     */
    public void setImmatriculationNumber(String immatriculationNumber) {
        this.immatriculationNumber = immatriculationNumber;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }


}
