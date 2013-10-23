/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.actions;

import com.gmail.shinsensei.deliverablesHub.logic.TeamsFacadeRemote;
import com.gmail.shinsensei.deliverablesHub.utils.ServiceLocator;
import com.gmail.shinsensei.deliverablesHub.utils.to.StudentTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.TeamTO;
import com.opensymphony.xwork2.Action;
import java.util.LinkedList;
import java.util.List;
//import deliverablesHub.logic.TeamsRemote;

/**
 *
 * @author Francesco Bux
 */
public class Teams extends ControllerBase{
    
    TeamsFacadeRemote teams = ServiceLocator.lookupTeamsFacadeRemote();
    
//    TeamsRemote teams = lookupTeamsRemote();
    private int teamId;
    private int studentId;
    private int courseId;
    private int projectId;
    private String password;
    private TeamTO team;
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public TeamTO getTeam() {
        return team;
    }

    public void setTeam(TeamTO team) {
        this.team = team;
    }

    /**
     * Get the value of studentId
     *
     * @return the value of studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Set the value of studentId
     *
     * @param studentId new value of studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    /**
     * Get the value of TeamId
     *
     * @return the value of TeamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Set the value of TeamId
     *
     * @param TeamId new value of TeamId
     */
    public void setTeamId(int TeamId) {
        this.teamId = TeamId;
    }

    
    public Teams() {
    }
    
    
    public String create_team() { 
        if(this.getFormSubmit() !=null){
            if(this.getCourseId() > 0){
                int userId = Integer.parseInt((String)this.session.get(Auth.SYSTEM_ID));
                List<StudentTO> members = new LinkedList<StudentTO>();
                members.add(new StudentTO(userId));
                TeamTO newTeam = new TeamTO(0, this.getCourseId(), this.getPassword(), members);
                if(this.teams.createTeam(newTeam) != null)
                    return Action.SUCCESS;
                else
                    return Action.INPUT;
            }
        }else
            return Action.INPUT;
        return Action.SUCCESS; 
    }
    
    public String join_team() {
        TeamTO team = this.teams.details(this.getTeamId());
        int userId = Integer.parseInt((String)this.session.get(Auth.SYSTEM_ID));
        for(TeamTO courseTeam : this.teams.getCourseTeams(team.getCourseId()))
            if(courseTeam.getMembers().contains(new StudentTO(userId)))
                return Action.ERROR;
        this.teams.joinTeam(team.getTeamId(), userId);
        return Action.SUCCESS; 
    }
    
    public String details() { 
        this.setTeam(this.teams.details(this.getTeamId()));
        return Action.SUCCESS; 
    }
    
    public String submitted_files() {return Action.SUCCESS; }
    public String grant_view_permission(){return Action.SUCCESS; }


}
