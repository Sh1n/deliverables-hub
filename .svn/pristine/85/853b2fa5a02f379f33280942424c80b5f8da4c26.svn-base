/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

/**
 * Person Class
 * @author Francesco Bux
 */

@Entity
//@Table(name="persons" ,catalog="deliverables_hub" , uniqueConstraints = @UniqueConstraint(columnNames="immatriculationNumber"))
@DiscriminatorValue("PROFESSOR")
public class Professor extends Person {
    
    private Set<Course> courses = new HashSet(0);
    
    public Professor(){}
    
    public Professor(SystemUser systemUser, String firstName, String lastName) {
        super(systemUser, firstName, lastName);
    }
    
    public Professor(SystemUser systemUser, String firstName, String lastName, Set<Course> courses) {
        super(systemUser, firstName, lastName);
        this.courses = courses;
    }
    
    /* =========== Fields ========== */
    
    
    /* ========== Relationships ========== */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "professors")
    public Set<Course> getCourses() {
            return this.courses;
    }

    public void setCourses(Set<Course> courses) {
            this.courses = courses;
    }
    
}
