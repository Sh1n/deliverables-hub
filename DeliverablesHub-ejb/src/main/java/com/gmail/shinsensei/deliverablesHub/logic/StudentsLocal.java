/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import javax.ejb.Local;

/**
 *
 * @author utente
 */
@Local
public interface StudentsLocal {

    StudentTO addStudent(StudentTO student);

    StudentTO details(int studentId);
    
}
