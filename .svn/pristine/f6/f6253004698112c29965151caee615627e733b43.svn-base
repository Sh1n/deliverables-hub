/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Francesco Bux
 */
@Entity
@Table(name="deliverables"
    ,catalog="deliverables_hub"
)
public class Deliverable implements java.io.Serializable{
    
    private Integer deliverableId;
    private Project project;
    private String name;
    private String description;
    private Date deadline;
    
    private Set<TeamDeliverable> teamDeliverables = new HashSet(0);
    

    public static String DELIVERABLE_ID = "deliverableID";
    public static String NAME       = "name";
    public static String DESCRIPTION= "description";
    public static String DEADLINE   = "deadline";
    
    public Deliverable() {
    }
    
    public Deliverable(Project project, String name, Date deadline) {
        this.project = project;
        this.name = name;
        this.deadline = deadline;
    }
    
    public Deliverable(Project project, String name, String description, Date deadline, Set<TeamDeliverable> teamDeliverables) {
       this.project = project;
       this.name = name;
       this.description = description;
       this.deadline = deadline;
       this.teamDeliverables = teamDeliverables;
    }
    
    /* ====== Fields ========= */
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="deliverableID", unique=true, nullable=false)
    public Integer getDeliverableId() {
        return this.deliverableId;
    }
    
    public void setDeliverableId(Integer deliverableId) {
        this.deliverableId = deliverableId;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projectID", nullable=false)
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
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
    
    @Temporal(TemporalType.DATE)
    @Column(name="deadline", nullable=false, length=10)
    public Date getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    // team deliverables
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.deliverable")
    public Set<TeamDeliverable> getTeamDeliverables() {
            return this.teamDeliverables;
    }

    public void setTeamDeliverables(Set<TeamDeliverable> teamDeliverables) {
            this.teamDeliverables = teamDeliverables;
    }
}
