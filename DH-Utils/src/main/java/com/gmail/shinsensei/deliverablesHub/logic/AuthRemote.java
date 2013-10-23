/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import javax.ejb.Remote;

/**
 *
 * @author utente
 */
@Remote
public interface AuthRemote {
    
    public boolean login(String email, String password);
    
    public SystemUserTO login(SystemUserTO user);
}
