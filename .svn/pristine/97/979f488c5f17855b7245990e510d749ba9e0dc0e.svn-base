/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Francesco Bux
 */
@Entity
@Table(name="courses", catalog="deliverables_hub")
public class Course implements java.io.Serializable{
    
    public static String COURSE_ID = "courseID";
    public static String NAME = "name";
    public static String YEAR = "year";
    public static String SECTOR = "sector";
    public static String CODE = "code";
                                    

    private Integer courseId;
    private String name;
    private String academicYear;
    private String sector;
    private String code;
    private Set<Project> projects = new HashSet(0);
    private Set<Person> professors = new HashSet(0);
    private Set<Team> teams = new HashSet(0);
    
    public Course() {
    }

	
    public Course(String name, String academicYear, String sector, String code) {
        this.name = name;
        this.academicYear = academicYear;
        this.sector = sector;
        this.code = code;
    }
    
    public Course(String name, String academicYear, String sector, String code, Set<Project> projects, Set<Person> professors, Set<Team> teams) {
        this.name = name;
        this.academicYear = academicYear;
        this.sector = sector;
        this.code = code;
        this.projects = projects;
        this.professors = professors;
        this.teams = teams;
    }
    
    /* ====== Fields ====== */
     
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="courseID", unique=true, nullable=false)
    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="academicYear", nullable=false, length=9)
    public String getAcademicYear() {
        return this.academicYear;
    }
    
    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
    
    @Column(name="sector", nullable=false, length=45)
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    @Column(name="code", nullable=false, length=45)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    public Set<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "courses_professors", catalog="deliverables_hub", joinColumns = { 
    @JoinColumn(name = "courseID", nullable = false, updatable = false) }, 
    inverseJoinColumns = { @JoinColumn(name = "professorID", nullable = false, updatable = false) })
    public Set<Person> getProfessors() {
        return this.professors;
    }

    public void setProfessors(Set<Person> professors) {
        this.professors = professors;
    }
    
}
