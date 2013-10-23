package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Facade for student bean
 * @author Francesco Bux
 */
@Stateless
public class StudentsFacade implements StudentsFacadeRemote {
    
    @EJB
    private StudentsLocal students;
    @EJB
    private AuthLocal auth;

    @Override
    public StudentTO addStudent(StudentTO student) {
        SystemUserTO user = student.getSystemUserTO();
        if(user == null)
            return null;
        try{
            return students.addStudent(new StudentTO(student.getFirstName(), student.getLastName(), student.getImmatriculationNumber(), user));
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public StudentTO getStudentById(int studentId) {
        return null;
    }

}
