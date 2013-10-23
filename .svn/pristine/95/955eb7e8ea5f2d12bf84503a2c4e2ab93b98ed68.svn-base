/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Person Class
 * @author Francesco Bux
 */

@Entity
@Table(name="persons" ,catalog="deliverables_hub" , uniqueConstraints = @UniqueConstraint(columnNames="immatriculationNumber"))
@org.hibernate.annotations.Entity(dynamicUpdate =true)  
public class Person implements java.io.Serializable {
    
    
    private SystemUser systemUser;
    private Integer userId;
    private String firstName;
    private String lastName;
    
    private Integer immatriculationNumber;
    private Set<Course> courses = new HashSet(0);
    private Set<Team> teams = new HashSet(0);

    public static final String TABLE_NAME = "persons";
    public static final String FIRST_NAME  = "firstName";
    public static final String LAST_NAME   = "lastName";
    public static final String IMMATRICULATION_NUMBER = "immatriculationNumber";
    
    public Person(){}
    
    public Person(SystemUser systemUser) {
        this.systemUser = systemUser;
        //this.firstName = firstName;
        //this.lastName = lastName;
    }
    
    public Person(SystemUser systemUser, String firstName, String lastName) {
        this.systemUser = systemUser;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Person(SystemUser systemUser, String firstName, String lastName, Integer immatriculationNumber) {
        this.systemUser = systemUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.immatriculationNumber = immatriculationNumber;
    }
    
    public Person(SystemUser systemUser, String firstName, String lastName, Set<Course> courses) {
        this.systemUser = systemUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }
    
    public Person(SystemUser systemUser, String firstName, String lastName, Integer immatriculationNumber, Set<Team> teams) {
        this.systemUser = systemUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teams = teams;
    }
    /* =========== Fields ========== */
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "systemUser"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "userID", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }
 
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public SystemUser getSystemUser() {
        return this.systemUser;
    }
 
    public void setSystemUser(SystemUser sysUser) {
        this.systemUser = sysUser;
    }
    
    @Column(name="firstName", nullable=false, length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="lastName", nullable=false, length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="immatriculationNumber", unique=true, length=45)
    public Integer getImmatriculationNumber() {
        return this.immatriculationNumber;
    }
    
    public void setImmatriculationNumber(Integer immatriculationNumber) {
        this.immatriculationNumber = immatriculationNumber;
    }
 
    // teams
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    public Set<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
    
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "professors")
    public Set<Course> getCourses() {
            return this.courses;
    }

    public void setCourses(Set<Course> courses) {
            this.courses = courses;
    }
    
}
