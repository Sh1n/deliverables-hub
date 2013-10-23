/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.utils.to;

import com.gmail.shinsensei.deliverablesHub.entities.Deliverable;
import com.gmail.shinsensei.deliverablesHub.entities.Project;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Francesco Bux
 */
public class ProjectTO {
    
    private final int projectId;
    private final int courseId;
    private final String name;

    public int getCourseId() {
        return courseId;
    }

    public List<DeliverableTO> getDeliverables() {
        return deliverables;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getProjectId() {
        return projectId;
    }
    private final String description;
    private final List<DeliverableTO> deliverables;
    
    public ProjectTO(int projectId)
    {
        this.projectId = projectId;
        this.courseId = 0;
        this.name = "";
        this.description = "";
        this.deliverables = Collections.EMPTY_LIST;
    }
    
    public ProjectTO(int projectId, int course, String name, String description){
        this.projectId = projectId;
        this.courseId = course;
        this.name = name;
        this.description = description;
        this.deliverables = Collections.EMPTY_LIST;
    }
    
    public ProjectTO(int projectId, int course, String name, String description, List<DeliverableTO> deliverables){
        this.projectId = projectId;
        this.courseId = course;
        this.name = name;
        this.description = description;
        this.deliverables = deliverables;
    }
    
    public ProjectTO(Project p){
        this.projectId = p.getProjectId();
        this.courseId = p.getCourse().getCourseId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.deliverables = new LinkedList<DeliverableTO>();
        for(Deliverable d : p.getDeliverables())
            this.deliverables.add(new DeliverableTO(d));
        
    }
    
}
