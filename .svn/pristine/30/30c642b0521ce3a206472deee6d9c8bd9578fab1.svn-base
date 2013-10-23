<%-- 
    Document   : Student Details
    Created on : 04-sep-2012, 16.49.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../components/header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@include  file="../components/sidebar.jsp" %>
        <div class="span9">
            <h2>Student Details - <s:property value="#student.getLastName()" /> <s:property value="#student.getFirstName()" /> : <s:property value="#student.getImmatriculationNumber()" /></h2>
            <div class="row-fluid">
                <section id="joinedCourses">
                <div class="well span6">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Course</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="#student.getFollowedCourses()" var="course">
                                <tr>
                                    <td>
                                        <s:property value="#course.getName()" />
                                    </td>
                                    <td>
                                        <s:a namespace="courses/" method="view/{#course.getCourseId()}" cssClass="btn btn-info btn-mini">
                                            <i class="icon-info-sign"></i></s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                <hr />
                </section>
                <section id="joinedTeams">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Team</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="#student.getTeams()" var="team">
                                <tr>
                                    <td>
                                        <s:property value="#team.getTeamId()" />
                                    </td>
                                    <td>
                                        <s:a namespace="courses/" method="view/{#course.getCourseId()}" cssClass="btn btn-info btn-mini">
                                            <i class="icon-info-sign"></i></s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                <hr />
                </section>
            </div>
        </div><!--/span-->
    </div><!--/row-->
    <%@include file="../components/footer.jsp" %>
    