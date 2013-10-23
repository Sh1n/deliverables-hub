/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProfessorTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author utente
 */
@Remote
public interface ProfessorsFacadeRemote {

    ProfessorTO addProfessor(ProfessorTO professor);

    List<ProfessorTO> getProfessorsList();
    
    ProfessorTO getProfessorById(int professorId);

    boolean editProfessor(ProfessorTO professor);

    List<CourseTO> coursesHeld(int professorId);

    boolean remove(int professorId);
    
}
