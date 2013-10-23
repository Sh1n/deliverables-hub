/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.DeliverableTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProjectTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author utente
 */
@Remote
public interface CoursesFacadeRemote {

    CourseTO addCourse(CourseTO newCourse);

    boolean assignProfessorToCourse(int courseId, int professorId);

    boolean joinCourse(int courseId, int studentId);

    ProjectTO createProject(ProjectTO project);

    DeliverableTO createDeliverable(DeliverableTO newDeliverable);

    List<CourseTO> listCourses();

    CourseTO viewCourse(int courseId);
    
}
