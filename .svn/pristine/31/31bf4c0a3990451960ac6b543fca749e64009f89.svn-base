/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.actions;

import com.gmail.shinsensei.deliverablesHub.Message;
import com.gmail.shinsensei.deliverablesHub.logic.CoursesFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.utils.ServiceLocator;
import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.DeliverableTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProjectTO;
import com.opensymphony.xwork2.Action;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Francesco Bux
 */
public class Courses extends ControllerBase{
    
    CoursesFacadeRemote courses = ServiceLocator.lookupCoursesFacadeRemote();
    
    public List<CourseTO> coursesList = new LinkedList<CourseTO>();
    protected String courseName;
    private CourseTO course;

    public CourseTO getCourse() {
        return course;
    }

    public void setCourse(CourseTO course) {
        this.course = course;
    }
    
    
    public Courses(){
        this.setSessionVar("submission", false);
    }

    /**
     * Get the value of courseName
     *
     * @return the value of courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the value of courseName
     *
     * @param courseName new value of courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    protected String courseYear;

    /**
     * Get the value of courseYear
     *
     * @return the value of courseYear
     */
    public String getCourseYear() {
        return courseYear;
    }

    /**
     * Set the value of courseYear
     *
     * @param courseYear new value of courseYear
     */
    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    /**
     * Get the value of coursesList
     *
     * @return the value of coursesList
     */
    public List<CourseTO> getCoursesList() {
        return coursesList;
    }
    protected String courseCode;

    /**
     * Get the value of courseCode
     *
     * @return the value of courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Set the value of courseCode
     *
     * @param courseCode new value of courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    
    protected String courseSector;
    
    /**
     * Get the value of courseSector
     *
     * @return the value of courseSector
     */
    public String getCourseSector() {
        return courseSector;
    }

    /**
     * Set the value of courseSector
     *
     * @param courseSector new value of courseSector
     */
    public void setCourseSector(String courseSector) {
        this.courseSector = courseSector;
    }
    
    /**
     * Set the value of coursesList
     *
     * @param coursesList new value of coursesList
     */
    public void setCoursesList(List<CourseTO> coursesList) {
        this.coursesList = coursesList;
    }
    
    
                
    private int courseId;

    /**
     * Get the value of courseId
     *
     * @return the value of courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Set the value of courseId
     *
     * @param courseId new value of courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    private String addCourse;

    /**
     * Get the value of addCourse
     *
     * @return the value of addCourse
     */
    public String getAddCourse() {
        return addCourse;
    }

    /**
     * Set the value of addCourse
     *
     * @param addCourse new value of addCourse
     */
    public void setAddCourse(String addCourse) {
        this.addCourse = addCourse;
    }
    private Message message;

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * ===================================
     * Course section 
     * ===================================
     */
    
    public String list_courses() { 
        this.coursesList.clear();
        this.coursesList = this.courses.listCourses();
        for(CourseTO c : this.getCoursesList())
            System.out.println(c.getName());
        return Action.SUCCESS; 
    }
    
    public String view()
    {
        if(this.getCourseId() <= 0)
            return Action.INPUT;
        this.setCourse(this.courses.viewCourse(this.getCourseId()));
        return Action.SUCCESS;
    }

    
    /**
     * Method used to join a course. Only a student is entitled to join a course
     * and iff it has not joined it already. Expected result should be encoded
     * in JSON. Th method has to take two parameters, the first is the courseId 
     * and the second is the student one. The latest one can be obtained from the 
     * session object, hence only one parameter is necessary to be passed, courseId.
     * courseId will be passed as url parameter
     * 
     * student only
     * 
     * @return 
     * 
     */
    public String join_course(){
        System.out.println("Chiamata join course with " + this.getCourseId());
        int userId = Integer.parseInt((String)this.session.get(Auth.SYSTEM_ID));
        if(this.courses.joinCourse(this.getCourseId(), userId)){
            this.jsonResponse.put("status", AjaxAction.SUCCESS);
            this.jsonResponse.put("responseMessage", "Course joined");
            return AjaxAction.SUCCESS;
        }else{
            this.jsonResponse.put("status", AjaxAction.ERROR);
            this.jsonResponse.put("responseMessage", "Course not joined");
            return AjaxAction.ERROR;
        }
    }
    
    /**
     * DEV DONE
     * TEST ??
     * admin only
     * @return 
     */
    public String add_course(){
        if(this.getFormSubmit() != null){
            if(!this.getCourseName().isEmpty() && !this.getCourseCode().isEmpty() && !this.getCourseYear().isEmpty() && !this.getCourseSector().isEmpty()){
                CourseTO newCourse = new CourseTO(0, this.getCourseName(), this.getCourseYear(), this.getCourseSector(), this.getCourseCode());
                System.out.println(newCourse);
                if((newCourse = this.courses.addCourse(newCourse)) != null){
                    this.setCourse(newCourse);
                    this.jsonResponse.put("status", AjaxAction.SUCCESS);
                    this.jsonResponse.put("responseMessage", "Course Added Correctly");
                    this.jsonResponse.put("newCourse", newCourse);
                    return AjaxAction.SUCCESS;
                }else{
                    this.jsonResponse.put("status", AjaxAction.ERROR);
                    this.jsonResponse.put("responseMessage", "Error adding course");
                    return AjaxAction.ERROR; 
                }
            }else{
                System.out.println("Submitted data not valid");
                this.jsonResponse.put("status", AjaxAction.INPUT);
                this.jsonResponse.put("responseMessage", "Submitted data not valid");
                return AjaxAction.INPUT; 
            }
        }else{
            System.out.println("Data not submitted");
            this.jsonResponse.put("status", AjaxAction.INPUT);
            this.jsonResponse.put("responseMessage", "Data not submitted");
            return AjaxAction.INPUT; 
        }
    }
    /*
     * ===============
     * Project Section
     * ===============
     */
    private String projectName;
    private String projectDescription;
    private ProjectTO project;
    private int projectId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public ProjectTO getProject() {
        return project;
    }

    public void setProject(ProjectTO project) {
        this.project = project;
    }
    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    /*
     * professor only
     */
    public String create_project(){
        if(this.getFormSubmit() != null){
            if(!this.getProjectName().isEmpty() && !this.getProjectDescription().isEmpty() && this.getCourseId() != 0){
                ProjectTO newProject = new ProjectTO(0, this.getCourseId(), this.getProjectName(), this.getProjectDescription());
                if((newProject = this.courses.createProject(newProject)) != null){
                    this.setProject(newProject);
                    this.jsonResponse.put("status", AjaxAction.SUCCESS);
                    this.jsonResponse.put("responseMessage", "Project Added Correctly");
                    this.jsonResponse.put("newProject", newProject);
                    return AjaxAction.SUCCESS;
                }else{
                    this.jsonResponse.put("status", AjaxAction.ERROR);
                    this.jsonResponse.put("responseMessage", "Error adding project");
                    return AjaxAction.ERROR; 
                }
            }else{
                System.out.println("Submitted data not valid");
                this.jsonResponse.put("status", AjaxAction.INPUT);
                this.jsonResponse.put("responseMessage", "Submitted data not valid");
                return AjaxAction.INPUT; 
            }
        }else{
            System.out.println("Data not submitted");
            this.jsonResponse.put("status", AjaxAction.INPUT);
            this.jsonResponse.put("responseMessage", "Data not submitted");
            return AjaxAction.INPUT; 
        }
    }
    
    /*
     * ===================
     * Deliverable Section
     */
    private DeliverableTO deliverable;
    private String deliverableName;
    private String deliverableDescription;
    private int deliverableId;
    private String deliverableDeadline;

    public String getDeliverableDeadline() {
        return deliverableDeadline;
    }

    public void setDeliverableDeadline(String deliverableDeadline) {
        this.deliverableDeadline = deliverableDeadline;
    }

    public DeliverableTO getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(DeliverableTO deliverable) {
        this.deliverable = deliverable;
    }

    public String getDeliverableDescription() {
        return deliverableDescription;
    }

    public void setDeliverableDescription(String deliverableDescription) {
        this.deliverableDescription = deliverableDescription;
    }

    public int getDeliverableId() {
        return deliverableId;
    }

    public void setDeliverableId(int deliverableId) {
        this.deliverableId = deliverableId;
    }

    public String getDeliverableName() {
        return deliverableName;
    }

    public void setDeliverableName(String deliverableName) {
        this.deliverableName = deliverableName;
    }
  
    /*
     * professors only
     */
    public String create_deliverable() {
        if(this.getFormSubmit() != null){
            if(!this.getProjectName().isEmpty() && !this.getProjectDescription().isEmpty() && this.getProjectId() != 0){
                DeliverableTO newDeliverable = null;
                
                try{
                    newDeliverable = new DeliverableTO(0, this.getProjectId(), this.getDeliverableName(), this.getDeliverableDescription(), new SimpleDateFormat("dd/MM/yyyy").parse(this.getDeliverableDeadline()));
                }catch(Exception ex){
                    System.out.println("Submitted data not valid : " + ex.getMessage());
                    this.jsonResponse.put("status", AjaxAction.INPUT);
                    this.jsonResponse.put("responseMessage", "Submitted data not valid : " +ex.getMessage());
                    return AjaxAction.INPUT; 
                }
                
                if((newDeliverable = this.courses.createDeliverable(newDeliverable)) != null){
                    this.setDeliverable(newDeliverable);
                    this.jsonResponse.put("status", AjaxAction.SUCCESS);
                    this.jsonResponse.put("responseMessage", "Deliverable added correctly");
                    this.jsonResponse.put("newDeliverable", newDeliverable);
                    return AjaxAction.SUCCESS;
                }else{
                    this.jsonResponse.put("status", AjaxAction.ERROR);
                    this.jsonResponse.put("responseMessage", "Error adding deliverable");
                    return AjaxAction.ERROR; 
                }
            }else{
                System.out.println("Submitted data not valid");
                this.jsonResponse.put("status", AjaxAction.INPUT);
                this.jsonResponse.put("responseMessage", "Submitted data not valid");
                return AjaxAction.INPUT; 
            }
        }else{
            System.out.println("Data not submitted");
            this.jsonResponse.put("status", AjaxAction.INPUT);
            this.jsonResponse.put("responseMessage", "Data not submitted");
            return AjaxAction.INPUT; 
        }
    }
    
    
}
