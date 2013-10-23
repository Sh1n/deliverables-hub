/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.TeamTO;
import javax.ejb.Local;

/**
 *
 * @author utente
 */
@Local
public interface TeamsLocal {

    TeamTO createTeam(TeamTO newTeam);

    boolean joinTeam(int teamId, int studentId);

    TeamTO details(int teamId);

    boolean grantViewPermission(int fromTeam, int toTeam);
    
}
