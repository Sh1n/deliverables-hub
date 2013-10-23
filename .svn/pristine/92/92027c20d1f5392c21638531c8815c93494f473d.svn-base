/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Deliverable;
import java.util.Date;

/**
 *
 * @author Francesco Bux
 */
public class DeliverableTO {
    
    private final int deliverableID;
    private final int projectID;
    private final String name;
    private final String description;
    private final Date deadline;
    // TODO team deliverable

    public int getDeliverableID() {
        return deliverableID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getProjectID() {
        return projectID;
    }
    public Date getDeadline(){
        return this.deadline;
    }
    
    public DeliverableTO(int deliverableID){
        this.deliverableID = deliverableID; 
        this.projectID = 0;
        this.name = "";
        this.description = "";
        this.deadline = null;
               
    }
    
    public DeliverableTO(int deliverableID, int projectID, String name, String description, Date deadline){
        this.deliverableID = deliverableID;
        this.projectID = projectID;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }
    
    
    
    public DeliverableTO(Deliverable d){
        this.deliverableID = d.getDeliverableId();
        this.name = d.getName();
        this.projectID = d.getProject().getProjectId();
        this.description = d.getDescription();
        this.deadline = d.getDeadline();
    }
}
