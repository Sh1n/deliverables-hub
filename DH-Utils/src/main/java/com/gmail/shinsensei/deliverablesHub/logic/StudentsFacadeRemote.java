/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import javax.ejb.Remote;

/**
 *
 * @author utente
 */
@Remote
public interface StudentsFacadeRemote {

    StudentTO addStudent(StudentTO student);

    StudentTO getStudentById(int studentId);
    
}
