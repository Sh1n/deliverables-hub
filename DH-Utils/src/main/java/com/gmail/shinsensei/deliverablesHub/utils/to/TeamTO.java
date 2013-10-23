/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Person;
import com.gmail.shinsensei.deliverablesHub.entities.Team;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Francesco Bux
 */
public class TeamTO {
    
    private final int teamId;
    private final int courseId;
    private final CourseTO course;
    private final String password;
    private final List<StudentTO> members;
    // submitted delierable;

    public CourseTO getCourse() {
        return course;
    }

    public List<StudentTO> getMembers() {
        return members;
    }

    public String getPassword() {
        return password;
    }

    public int getTeamId() {
        return teamId;
    }
    
    public int getCourseId() {
        return courseId;
    }
    
    
    public TeamTO(int teamId, CourseTO course, String password, List<StudentTO> members){
        this.teamId = teamId;
        this.course = course;
        this.password = password;
        this.members = members;
        this.courseId = course.getCourseId();
    }
    
    public TeamTO(int teamId, int courseId, String password, List<StudentTO> members){
        this.teamId = teamId;
        this.course = null;
        this.courseId = courseId;
        this.password = password;
        this.members = members;
    }
    
    public TeamTO(Team t){
        this.teamId = t.getTeamId();
        this.course = null;
        this.courseId = this.course.getCourseId();
        this.password = t.getPassword();
        this.members = new LinkedList<StudentTO>();
        for(Person p : t.getStudents())
            this.members.add(new StudentTO(p));
    }
}
