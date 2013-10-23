/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.entities.HibernateUtil;
import com.gmail.shinsensei.deliverablesHub.entities.Person;
import com.gmail.shinsensei.deliverablesHub.entities.SystemUser;
import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserType;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

/**
 *
 * @author Francesco Bux
 */
@Stateless
public class Students implements StudentsLocal {

    private Session session;
    public Students(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public StudentTO addStudent(StudentTO newStudent) {
        session.beginTransaction();
 
        SystemUser studentUser = new SystemUser();
        
        studentUser.setEmail(newStudent.getSystemUserTO().getEmail());
        studentUser.setPassword(newStudent.getSystemUserTO().getPassword());
        studentUser.setType(SystemUserType.lookup("STUDENT").toString().toUpperCase());
	studentUser.setRegistrationDate(new Date());	
        
	Person student = new Person();
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setImmatriculationNumber(newStudent.getImmatriculationNumber());
		
        studentUser.setPerson(student);
        student.setSystemUser(studentUser);
 
        session.save(studentUser);
        session.flush();
        session.refresh(studentUser); // ha l'id
        session.getTransaction().commit();
        return new StudentTO(student);
    }

    @Override
    public StudentTO details(int studentId) {
        StudentTO student = null;
        session.beginTransaction();
        Property userIdProp = Property.forName(SystemUser.USER_ID);
        List users = session.createCriteria(Person.class)
                .setMaxResults(1)
                .add(userIdProp.eq(studentId)).list();
        Person tmp = null;
        if(users.size() == 1){  // user found
            System.out.println("Result found, build the student object");
            tmp = (Person) users.get(0);
            student = new StudentTO((Person) users.get(0));
        }else{
            System.out.println("Student not found");
        }
        session.getTransaction().commit();
        session.close();
        return student;
    }
    
}
