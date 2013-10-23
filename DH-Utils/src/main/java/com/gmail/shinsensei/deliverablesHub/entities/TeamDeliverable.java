/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;

import java.beans.Transient;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Francesco Bux
 */
@Entity
@Table(name = "team_deliverables", catalog = "deliverables_hub")
@AssociationOverrides({
		@AssociationOverride(name = "pk.team", 
			joinColumns = @JoinColumn(name = "teamID")),
		@AssociationOverride(name = "pk.deliverable", 
			joinColumns = @JoinColumn(name = "deliverableID")) })
public class TeamDeliverable implements java.io.Serializable {
    
    private TeamDeliverableId pk = new TeamDeliverableId();
    private Integer score;
    private String note;
    private byte[] file;
    
    public TeamDeliverable() {
    }

    public TeamDeliverable(TeamDeliverableId pk, Integer score, String note, byte[] file){
        this.setPk(pk);
        this.setScore(score);
        this.setNote(note);
        this.setFile(file);
    }
    
    
    /* ==== FIELDS ==== */
    @EmbeddedId
    public TeamDeliverableId getPk(){
        return this.pk;
    }
    
    public void setPk(TeamDeliverableId pk){
        this.pk = pk;
    }
    
    @Transient
    public Team getTeam() {
        return getPk().getTeam();
    }
 
    public void setTeam(Team team) {
        getPk().setTeam(team);
    }
 
    @Transient
    public Deliverable getDeliverable() {
        return getPk().getDeliverable();
    }

    public void setDeliverable(Deliverable deliverable) {
        getPk().setDeliverable(deliverable);
    }
    
    
    @Column(name="score", nullable=true)
    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    @Column(name="note", length=65535, nullable=true)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    @Column(name="file", nullable=false)
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }
    
    public boolean equals(Object o) {
        if (this == o)
                return true;
        if (o == null || getClass() != o.getClass())
                return false;

        TeamDeliverable that = (TeamDeliverable) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                        : that.getPk() != null)
                return false;

        return true;
    }
 
    public int hashCode() {
            return (getPk() != null ? getPk().hashCode() : 0);
    }
}
