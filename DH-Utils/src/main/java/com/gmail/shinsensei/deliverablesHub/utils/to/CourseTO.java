package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Course;
import com.gmail.shinsensei.deliverablesHub.entities.Person;
import com.gmail.shinsensei.deliverablesHub.entities.Project;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Francesco Bux
 */
public final class CourseTO implements Serializable{
 
    final private int courseId;
    final private String name;
    final private String year;
    final private String sector;
    final private String code;
    final private List<ProjectTO> projects;
    final private List<ProfessorTO> professors;
    
    
    public CourseTO(int courseId, String name, String year, String sector, String code){
        this.courseId = courseId;
        this.name = name;
        this.year = year;
        this.sector = sector;
        this.code = code;
        this.projects = Collections.EMPTY_LIST;
        this.professors = Collections.EMPTY_LIST;
    }
    
    public CourseTO(int courseId, String name, String year, String sector, String code, List<ProjectTO> projects, List<ProfessorTO> professors){
        this.courseId = courseId;
        this.name = name;
        this.year = year;
        this.sector = sector;
        this.code = code;
        this.projects = projects;
        this.professors = professors;
    }
    
    public CourseTO(Course c){
        this.courseId = c.getCourseId();
        this.name = c.getName();
        this.year = c.getAcademicYear();
        this.sector = c.getSector();
        this.code = c.getCode();
        this.projects = new LinkedList();
        for(Project p : c.getProjects())
            this.projects.add(new ProjectTO(p));
        
        this.professors = new LinkedList();
        for(Person p : c.getProfessors())
            this.professors.add(new ProfessorTO(p));
    }
    
    public int getCourseId(){
        return this.courseId;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getSector(){
        return this.sector;
    }
    
    public String getCode(){
        return this.code;
    }
    public List<ProjectTO> getProjects() {
        return projects;
    }
}
