package com.gmail.shinsensei.deliverablesHub.utils.to;
import com.gmail.shinsensei.deliverablesHub.entities.Course;
import com.gmail.shinsensei.deliverablesHub.entities.Person;
import com.gmail.shinsensei.deliverablesHub.entities.Professor;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Transfer Object
 * @author Francesco Bux
 */
public final class ProfessorTO extends PersonTO implements Serializable{
    
    private List<CourseTO> coursesHeld;
    
    public ProfessorTO(int userid){
        super(userid);
    }
    
    public ProfessorTO(String firstName, String lastName){
        super(firstName, lastName);
    }
    
    public ProfessorTO(String firstName, String lastName, SystemUserTO sysUser){
        super(sysUser, firstName, lastName);
    }
    
    public ProfessorTO(String firstName, String lastName, SystemUserTO sysUser, List<CourseTO> coursesHeld){
        super(sysUser, firstName, lastName);
        this.coursesHeld = coursesHeld;
    }
    
    public ProfessorTO(String firstName, String lastName, SystemUserTO sysUser, Set<Course> coursesHeld){
        super(sysUser, firstName, lastName);
        this.coursesHeld = new LinkedList();
        for(Course c : coursesHeld){
            this.coursesHeld.add(new CourseTO(c));
        }
    }
    
    public ProfessorTO(PersonTO person, List<CourseTO> heldCourses){
        super(person);
        this.coursesHeld = heldCourses;
    }
    
    public ProfessorTO(Person prof){
        super(prof);
        this.coursesHeld = new LinkedList();
        for(Course c : prof.getCourses()){
            this.coursesHeld.add(new CourseTO(c));
        }
    }
    
    public ProfessorTO(Professor prof){
        super(prof);
        this.coursesHeld = new LinkedList();
        for(Course c : prof.getCourses()){
            this.coursesHeld.add(new CourseTO(c));
        }
    }
    
    public int getProfessorId(){
        return this.getUserId();
    }
    
    public List<CourseTO> getCoursesHeld(){
        return this.coursesHeld;
    }
    
}
