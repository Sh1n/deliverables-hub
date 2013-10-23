/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francesco Bux
 */
@Embeddable
public class TeamDeliverableId implements java.io.Serializable {
    
    private Deliverable deliverable;
    private Team team;

    @ManyToOne
    public Deliverable getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Deliverable deliverable) {
        this.deliverable = deliverable;
    }

    @ManyToOne
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        TeamDeliverableId that = (TeamDeliverableId) o;
 
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (deliverable != null ? !deliverable.equals(that.deliverable) : that.deliverable != null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (team != null ? team.hashCode() : 0);
        result = 31 * result + (deliverable != null ? deliverable.hashCode() : 0);
        return result;
    }
 
}
