/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Person;

/**
 *
 * @author Francesco Bux
 */
public class StudentTO extends PersonTO{
    
    private final int immatriculationNumber;

    public int getImmatriculationNumber() {
        return immatriculationNumber;
    }
    
    public StudentTO(int userid){
        super(userid);
        this.immatriculationNumber = 0;
    }
    
    public StudentTO(String firstName, String lastName, int immatriculationNumber, SystemUserTO user){
        super(user, firstName, lastName);
        this.immatriculationNumber = immatriculationNumber;
    }
    public StudentTO(PersonTO person, int immatriculationNumber){
        super(person);
        this.immatriculationNumber = immatriculationNumber;
    }
    
    public StudentTO(Person p){
        super(p);
        this.immatriculationNumber = p.getImmatriculationNumber();
    }

    public String toString() {
        return "StudentTO{" + "immatriculationNumber=" + immatriculationNumber + '}';
    }

}
