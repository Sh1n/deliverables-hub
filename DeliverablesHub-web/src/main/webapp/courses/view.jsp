<%-- 
    Document   : Display Detailed Information About a Course
    Created on : 14-nov-2011, 11.20.45
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../components/header.jsp" %>
<div class="container-fluid">        
    <div class="row-fluid">
        <%@include file="../components/sidebar.jsp" %>
        <div class="span9">
            <section id="courseHeading">
                <div class="row-fluid">
                    <div class="span9">
                        <h2><s:property value="#course.getName()" /></h2>
                        <blockquote>
                            <p><s:property value="#course.getDescription()" /></p>
                        </blockquote>
                    </div>
                    <div class="span3">
                        <h4>Actions</h4>
                        <!-- solo se utente -->
                        <s:form namespace="/courses" name="join_course/{courseId}">
                            <button type="submit" class="btn btn-primary btn-loading" data-loading-text="Joining..." name="formSubmission">Attend Course</button>
                            <button type="submit" class="btn btn-success btn-loading" data-loading-text="Joining..." name="formSubmission">Attending</button>
                        </s:form>
                        <hr />    
                        <h5>Team</h5> 
                        <div class="btn-toolbar">
                            <a class="btn" data-toggle="modal" role="button" data-target="#createTeamModal">Create Team</a>
                            <button class="btn btn-danger">Leave Team</button>
                            <div class="modal" id="createTeamModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" style="display:none;">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                    <h3 id="modalLabel">Create Team</h3>
                                </div>
                                <div class="modal-body">
                                    <s:form id="createTeamForm" namespace="/teams" action="create_team" theme="bootstrap" method="post">
                                        <s:password name="password" label="Password for private" />
                                        <s:hidden name="courseId" value="{courseId}" />
                                    </s:form>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                                    <button class="btn btn-primary" onClick="$('#createTeamForm').submit()">Create Team</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                    
            <section id="projects">
                <h3>Projects</h3>
                <hr/>
                <ul class="nav nav-tabs" id="projectTab">
                    <s:iterator value="course.getProjects()">
                        <li><a href="#project_<s:property value="value.getProjectId()"/>" data-toggle="tab"><s:property value="value.getName()"/></a></li>
                    </s:iterator>
                        <li><a href="#project_new" data-toggle="tab">Add project</a></li>
                </ul>

                <div class="tab-content">
                    <s:iterator value="course.getProjects()">
                    <div class="tab-pane" id="project_<s:property value="value.getProjectId()"/>">
                        <p><s:property value="value.getProjectDescription()"/></p>
                        <hr />
                        <div class="tabbable tabs-right">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#deliverables_list_<s:property value="value.getProjectId()"/>">List Deliverable</a></li>
                                <li><a href="#deliverables_add_<s:property value="value.getProjectId()"/>">Add Deliverable</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="deliverables_list_<s:property value="value.getProjectId()"/>">
                                    <div class="accordion" id="acc_<s:property value="value.getProjectId()"/>">
                                        <s:iterator value="value.getDeliverables()" var="deliverable">
                                            <!-- Deliverable BEGIN -->
                                            <h3>
                                                <a href="#">
                                                    <span class="pull-left">
                                                        <s:property value="deliverable.getName()" />
                                                    </span>
                                                    <span class="pull-rigth">
                                                        <s:property value="deliverable.getDeadline()" />
                                                    </span>
                                                </a>
                                            </h3>
                                            <div>
                                                <p><s:property value="deliverable.getDescription()" /></p>
                                            </div>
                                            <!-- submitted file cycles
                                                if admin null
                                                if professor submitted files
                                                if student file upload + granted view
                                            
                                                <div>
                                                    <p><s:property value="deliverable.DESCRIPTION" /></p>
                                                        <div style="float:left;">
                                                                <h4>File</h4> zrchdive.zip
                                                        </div>
                                                        <div style="float:right;">
                                                                <h4>Score</h4> 8/10
                                                        </div>
                                                        <div style="clear:both; display:block; visibility:hidden">&nbsp;</div>

                                                        <div class="spacer"></div>
                                                </div>
                                            -->
                                            <!-- Deliverable END -->
                                        </s:iterator>
                                    </div>
                                </div>
                                <div class="tab-pane" id="deliverables_add_<s:property value="value.getProjectId()"/>">
                                    <s:form method="post" theme="bootstrap" namespace="/courses" action="create_deliverable" class="add_deliverable form form-vertical">
                                        <s:textfield name="deliverableName" label="Name" />
                                        <s:textarea name="deliverableDescription" label="Description" />
                                        <s:textfield name="deliverableDeadline" label="Deadline" />
                                        <s:hidden name="projectId" value="value.getProjectId()"/>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary btn-loading" name="formSubmit" data-loading-text="Sending Data...">Add</button>
                                        </div>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </s:iterator>
                    <div class="tab-pane" id="project_new">
                        <s:form method="post" theme="bootstrap" namespace="/courses" action="create_project" id="add_project" class="form form-vertical">
                            <s:textfield name="projectName" label="Name" />
                            <s:textarea name="projectDescription" label="Description" />
                            <s:hidden name="courseId" value="{courseId}"/>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary btn-loading" name="formSubmit" data-loading-text="Sending Data...">Add</button>
                            </div>
                        </s:form>
                    </div>
                </div>
            </section>
            
            <!-- Teams -->
            <section id="teams">
                <h3>Teams</h3>
                <hr />
                <table class="table-bordered table-striped table" width="100%">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Delivered Files</th>
                            <th>Team</th>
                            <th>Actions</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Provolo</td>
                            <td>Download Archive</td>
                            <td>Check Members</td>
                            <td>
                                <a href="#" title=""><img src="img/icons/icon_edit.png" alt="Edit" /></a>
                                <a href="#" title=""><img src="img/icons/icon_approve.png" alt="Approve" /></a>
                                <a href="#" title=""><img src="img/icons/icon_unapprove.png" alt="Unapprove" /></a>
                                <a href="#" title=""><img src="img/icons/icon_delete.png" alt="Delete" /></a>
                            </td>
                            <td>
                                <button class="btn">Join Team</button>
                                <button class="btn btn-danger">Leave Team</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </section>
            </div><!-- row 9->
        </div><!--span-->
    </div><!--/row-->
        <%@include file="../components/footer.jsp" %>
        
        