/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.utils.to.TeamTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author utente
 */
@Stateless
public class TeamsFacade implements TeamsFacadeRemote {
    @EJB
    private TeamsLocal teams;

    //      <!-- Download Submitted Files -->
  

    @Override
    public TeamTO createTeam(TeamTO newTeam) {
        // courseId is valid
        return this.teams.createTeam(newTeam);
    }

    @Override
    public boolean joinTeam(int teamId, int studentId) {
        return this.teams.joinTeam(teamId, studentId);
    }

    @Override
    public TeamTO details(int teamId) {
        return this.teams.details(teamId);
    }

    @Override
    public boolean grantViewPermission(int fromTeam, int toTeam) {
        return this.teams.grantViewPermission(fromTeam, toTeam);
    }

    @Override
    public List<TeamTO> getStudentTeams(int studentID) {
        return null;
    }

    @Override
    public List<TeamTO> getCourseTeams(int courseId) {
        return null;
    }
    
}