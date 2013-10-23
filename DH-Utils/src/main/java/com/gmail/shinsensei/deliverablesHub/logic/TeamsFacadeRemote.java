/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.TeamTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author utente
 */
@Remote
public interface TeamsFacadeRemote {

    TeamTO createTeam(TeamTO newTeam);

    boolean joinTeam(int teamId, int studentId);

    TeamTO details(int teamId);

    boolean grantViewPermission(int fromTeam, int toTeam);

    List<TeamTO> getStudentTeams(int studentID);

    List<TeamTO> getCourseTeams(int courseId);
    
}
