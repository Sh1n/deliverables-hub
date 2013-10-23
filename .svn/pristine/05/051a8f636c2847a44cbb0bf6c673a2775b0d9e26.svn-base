package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Person;

/**
 *
 * @author Francesco Bux
 */
public class PersonTO extends SystemUserTO{
    
    protected final String firstName;
    protected final String lastName;
    
    public PersonTO(String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public PersonTO(int userID){
        super(userID);
        this.firstName = this.lastName = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public PersonTO(SystemUserTO systemUser, String firstName, String lastName){
        super(systemUser);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public PersonTO(PersonTO person){
        super(person.getSystemUserTO());
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }
    
    public PersonTO(Person p){
        super(p.getSystemUser());
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
    }
}
