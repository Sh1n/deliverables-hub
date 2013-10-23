<%-- 
    Document   : coursesHeld
    Created on : 15-lug-2012, 16.01.35
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h2>Courses Held</h2>
<s:if test="coursesHeld.size > 0">
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Year</th>
                <th>Sector</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="coursesHeld" var="course">
                <tr>
                    <td><s:property value="course.getName()" /></td>
                    <td><s:property value="course.getYear()" /></td>
                    <td><s:property value="course.getSector()" /></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    <div class="status info">
        No courses held by the professor
    </div>
</s:else>
