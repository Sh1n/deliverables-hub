/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.DeliverableTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProjectTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author utente
 */
@Local
public interface CoursesLocal {
    
    CourseTO addCourse(CourseTO course);

    boolean assignProfessorToCourse(int courseId, int professorId);

    List<CourseTO> listCourses();

    CourseTO viewCourse(int courseId);

    ProjectTO createProject(ProjectTO project);

    DeliverableTO createDeliverable(DeliverableTO deliverable);
    
}
