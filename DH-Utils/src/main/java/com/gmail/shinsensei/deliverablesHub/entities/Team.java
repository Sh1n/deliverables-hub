/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="teams"
    ,catalog="deliverables_hub"
)
public class Team implements java.io.Serializable{

    private Integer teamId;
    private Course course;
    private String password;
    private Set<Person> students = new HashSet(0);
    private Set<TeamDeliverable> teamDeliverables = new HashSet(0);
    
    public static final String TABLE_NAME = "teams";
    public static final String TEAM_ID = "teamID";
    public static final String PASSWORD = "password";
    
    public Team() {}

	
    public Team(Course course) {
        this.course = course;
    }
    public Team(Course course, String password, Set<Person> students, Set<TeamDeliverable> teamDeliverables){ //Set<TeamDeliverable> teamDeliverableses, Set personses) {
       this.course = course;
       this.password = password;
       this.students = students;
       this.teamDeliverables = teamDeliverables;
    }
    
    /* ===== FIELDS ====== */
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="teamID", unique=true, nullable=false)
    public Integer getTeamId() {
        return this.teamId;
    }
    
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
    
    // manu to one from course
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="courseID", nullable=false)
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course courses) {
        this.course = courses;
    }
    
    @Column(name="password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teams_students", catalog="deliverables_hub", joinColumns = { 
    @JoinColumn(name = "teamID", nullable = false, updatable = false) }, 
    inverseJoinColumns = { @JoinColumn(name = "studentID", nullable = false, updatable = false) })
    public Set<Person> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Person> students) {
        this.students = students;
    }
    
    // team Delvierable
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.team", cascade=CascadeType.ALL)  // team side
    public Set<TeamDeliverable> getTeamDeliverables() {
            return this.teamDeliverables;
    }

    public void setTeamDeliverables(Set<TeamDeliverable> teamDeliverables) {
            this.teamDeliverables = teamDeliverables;
    }
}
