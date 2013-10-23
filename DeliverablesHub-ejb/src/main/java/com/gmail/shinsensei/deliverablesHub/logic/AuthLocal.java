/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import javax.ejb.Local;

/**
 *
 * @author Francesco Bux
 */
@Local
public interface AuthLocal {

    SystemUserTO addSystemUser(SystemUserTO user);

    boolean editSystemUser(SystemUserTO user);
    
}
