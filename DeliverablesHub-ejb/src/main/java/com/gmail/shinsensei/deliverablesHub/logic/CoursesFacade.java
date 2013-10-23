/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.DeliverableTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProjectTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author utente
 */
@Stateless
public class CoursesFacade implements CoursesFacadeRemote {
    @EJB
    private ProfessorsLocal professors;
    
    @EJB
    private CoursesLocal courses;

    /*
     * To add a course are needed a name, a sector, a code
     * and an academic year
     */
    @Override
    public CourseTO addCourse(CourseTO newCourse) {
        return this.courses.addCourse(newCourse);
    }

    /*
     * To assign a professor to a course are needed a courseId and the professorId
     * which actually is an userid
     */
    @Override
    public boolean assignProfessorToCourse(int courseId, int professorId) {
        if(this.professors.getProfessorById(professorId) != null)
            return this.courses.assignProfessorToCourse(courseId, professorId);
        return false;
    }

    /**
     * FUTURE Development
     * @param courseId
     * @param studentId
     * @return 
     */
    @Override
    public boolean joinCourse(int courseId, int studentId) {
        return false;
        //TODO student bean needed
    }

    @Override
    public ProjectTO createProject(ProjectTO project) {
        return this.courses.createProject(project);
    }

    @Override
    public DeliverableTO createDeliverable(DeliverableTO newDeliverable) {
        return this.courses.createDeliverable(newDeliverable);
    }

    @Override
    public List<CourseTO> listCourses() {
        return this.courses.listCourses();
    }

    @Override
    public CourseTO viewCourse(int courseId) {
        return this.courses.viewCourse(courseId);
    }

    
    
}
