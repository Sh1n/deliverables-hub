package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.entities.Person;
import com.gmail.shinsensei.deliverablesHub.entities.SystemUser;
import com.gmail.shinsensei.deliverablesHub.logic.utils.HibernateUtil;
import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProfessorTO;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francesco Bux
 */
@Stateless(mappedName="dh/ejb/Professors")
public class Professors implements ProfessorsLocal {

    private Session session;
    public Professors(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    /**
     * DEV - DONE
     * TEST - ??
     * @return 
     */
    @Override
    public List<ProfessorTO> getProfessorsList() {
        List<ProfessorTO> profs = new LinkedList<ProfessorTO>();
        session.beginTransaction();
        Property immatriculation = Property.forName(Person.IMMATRICULATION_NUMBER);
        Iterator iter = session.createCriteria(Person.class).add(immatriculation.isNull()).list().iterator();
        while ( iter.hasNext() ) 
            profs.add(new ProfessorTO((Person) iter.next()));
        System.out.println(profs.toString());
        return profs;
    }

    /**
     * DEV - DONE
     * TEST - ??
     * @param professorId
     * @return 
     */
    @Override
    public ProfessorTO getProfessorById(int professorId) {
        System.out.println("Call with professorId = " + professorId);
        ProfessorTO prof = null;
        session.beginTransaction();
        List users = session.createCriteria(Person.class).add(Restrictions.eq("userId", professorId)).setMaxResults(1).list();
        if(users.size() == 1){
            System.out.println("Result found, build the professor object");
            prof = new ProfessorTO((Person) users.get(0));
        }else{
            System.out.println("Professor not found");
        }
        session.getTransaction().commit();
        return prof;
    }

    /**
     * DEV - DONE
     * TEST - DONE
     * @param newProfessorData
     * @return 
     */
    @Override
    public ProfessorTO addProfessor(ProfessorTO newProfessorData) {
        session.beginTransaction();
 
        SystemUser professorUser = new SystemUser();
        
        professorUser.setEmail(newProfessorData.getSystemUserTO().getEmail());
        professorUser.setPassword(newProfessorData.getSystemUserTO().getPassword());
        professorUser.setType(newProfessorData.getSystemUserTO().getType().toString().toUpperCase());
        professorUser.setRegistrationDate(new Date());	
        
	Person professor = new Person();
        professor.setFirstName(newProfessorData.getFirstName());
        professor.setLastName(newProfessorData.getLastName());
        	
        professorUser.setPerson(professor);
        professor.setSystemUser(professorUser);
 
        session.save(professorUser);
        
        session.flush();
        session.refresh(professorUser); // ha l'id
        session.getTransaction().commit();
        
        return new ProfessorTO(professor);
        
    }

    /**
     * Editing a professor means change its mail address or the first/last name 
     * associated to.
     * We update only the person data associated to the object 
     * since the modification is very tiny there's no need to use dynamic queries
     *   
     * DEV - ??
     * TEST - ?? 
     * @param professor
     * @return 
     */
    @Override
    public boolean editProfessor(ProfessorTO professor) {
        try{
            System.out.println("Edit Professor bean method called");
            Transaction tx = session.beginTransaction();
            
            List users = session.createCriteria(Person.class).add(Restrictions.eq("userId", professor.getSystemUserTO().getUserId())).setMaxResults(1).list();
            Person prof = (Person)users.get(0);
            prof.setFirstName(professor.getFirstName());
            prof.setLastName(professor.getLastName());
            prof.getSystemUser().setEmail(professor.getSystemUserTO().getEmail());
            session.update(prof);
            session.update(prof.getSystemUser());
            session.flush();
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Given the professor id, this method returns the list of courses 
     * associated to him.
     * DEV - DONE
     * TEST - ??
     * @param professorId
     * @return 
     */
    @Override
    public List<CourseTO> coursesHeld(int professorId) {
        ProfessorTO prof = this.getProfessorById(professorId);
        if(prof!= null)
            return prof.getCoursesHeld();
        return null;
    }

    @Override
    public boolean remove(int proessorId) {
        session.beginTransaction();
        List users = session.createCriteria(Person.class).add(Restrictions.eq("userId", proessorId)).setMaxResults(1).list();
        if(users.size() == 1){
            Person prof = (Person) users.get(0);
            session.delete(prof);
        }else{
            session.getTransaction().commit();
            System.out.println("Professor not found");
            return false;
        }
        session.getTransaction().commit();
        return true;
    }
    
    
}
