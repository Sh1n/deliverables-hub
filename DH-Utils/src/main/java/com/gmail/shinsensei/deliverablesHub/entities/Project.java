/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
/**
 *
 * @author Francesco Bux
 */
@Entity
@Table(name="projects" ,catalog="deliverables_hub")
public class Project implements java.io.Serializable {
    
    private Integer projectId;
    private Course course;
    private String name;
    private String description;
   
    private Set<Deliverable> deliverables = new HashSet(0);
    
    
    public static String PROJECT_ID = "projectID";
    public static String NAME = "name";
    public static String DESCRIPTION = "description";
     
    public Project() {}

    public Project(Course course, String name) {
        this.course = course;
        this.name = name;
    }
	
    public Project(Course course, String name, String description) {
        this.course = course;
        this.name = name;
        this.description = description;
    }
    
    public Project(Course course, String name, String description, Set<Deliverable> deliverables) {
        this.course = course;
        this.name = name;
        this.description = description;
        this.deliverables = deliverables;
    }
    
    /* ====== Fields ========= */
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="projectID", unique=true, nullable=false)
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID", nullable = false)
    public Course getCourse() {
        return this.course;
    }
 
    public void setCourse(Course course) {
            this.course = course;
    }
    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    // project -> +deliverable
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    public Set<Deliverable> getDeliverables() {
        return this.deliverables;
    }

    public void setDeliverables(Set<Deliverable> deliverables) {
            this.deliverables = deliverables;
    }
}

