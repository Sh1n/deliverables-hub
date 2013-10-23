/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

/**
 * Person Class
 * @author Francesco Bux
 */

//@Entity
//@DiscriminatorValue("STUDENT")
//@Table(name="persons" ,catalog="deliverables_hub" , uniqueConstraints = @UniqueConstraint(columnNames="immatriculationNumber"))
public class Student {//extends Person {
    
    private Integer immatriculationNumber;
    private Set<Team> teams = new HashSet(0);
    
    public static final String IMMATRICULATION_NUMBER = "immatriculationNumber";
  
    public Student(){}
    
    public Student(SystemUser systemUser, String firstName, String lastName, Integer immatriculationNumber) {
       //super(systemUser, firstName, lastName);
        this.immatriculationNumber = immatriculationNumber;
    }
    
    public Student(SystemUser systemUser, String firstName, String lastName, Integer immatriculationNumber, Set<Team> teams) {
       // super(systemUser, firstName, lastName);
        this.immatriculationNumber = immatriculationNumber;
        this.teams = teams;
    }
    
    /* =========== Fields ========== */
    @Column(name="immatriculationNumber", unique=true, length=45)
    public Integer getImmatriculationNumber() {
        return this.immatriculationNumber;
    }
    
    public void setImmatriculationNumber(Integer immatriculationNumber) {
        this.immatriculationNumber = immatriculationNumber;
    }
 
    // teams
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    public Set<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
