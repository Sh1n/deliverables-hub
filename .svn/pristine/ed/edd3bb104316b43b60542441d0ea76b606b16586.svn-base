package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProfessorTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * 
 * @author Francesco Bux
 */
@Stateless
public class ProfessorsFacade implements ProfessorsFacadeRemote {
    @EJB
    private ProfessorsLocal professors;
    @EJB
    private AuthLocal auth;

    @Override
    public ProfessorTO addProfessor(ProfessorTO professor) {
        SystemUserTO user = professor.getSystemUserTO();
        if(user == null)
            return null;
        try{
            return professors.addProfessor(new ProfessorTO(professor.getFirstName(), professor.getLastName(), user));
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public List<ProfessorTO> getProfessorsList() {
        return this.professors.getProfessorsList();
    }

    @Override
    public ProfessorTO getProfessorById(int professorId) {
        return this.professors.getProfessorById(professorId);
    }

    @Override
    public boolean editProfessor(ProfessorTO professor) {
        return this.professors.editProfessor(professor);
    }

    @Override
    public List<CourseTO> coursesHeld(int professorId) {
        return this.professors.coursesHeld(professorId);
    }

    @Override
    public boolean remove(int professorId) {
        return this.professors.remove(professorId);
    }
    
}
