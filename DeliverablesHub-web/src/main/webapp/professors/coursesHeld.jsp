<%-- 
    Document   : coursesHeld
    Created on : 15-lug-2012, 16.01.35
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h2>Courses Held</h2>
<s:if test="coursesHeld.size > 0">
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>Year</th>
                <th>Sector</th>
                <th>Code</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="coursesHeld" var="course">
                <tr>
                    <td>
                        <a href="<s:url value="courses/view/%{#course.getCourseId()}" />"><s:property value="#course.getName()" /></a>
                    </td>
                    <td><s:property value="#course.getYear()" /></td>
                    <td><s:property value="#course.getSector()" /></td>
                    <td><s:property value="#course.getCode()" /></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    <div class="alert alert-info">
        No courses held by the professor
    </div>
</s:else>
