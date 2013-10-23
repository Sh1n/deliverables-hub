<%-- 
    Document   : Professor Details
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../components/header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@include  file="../components/sidebar.jsp" %>
        <div class="span9">
            <h2>Team Details - #<s:property value="#team.getTeamId()" /></h2>
            <section id="members">
                <h3>Team Members</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Immatriculation Number</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="#team.getMembers()" var="student">
                            <tr>
                                <td>
                                    <s:a namespae="students/" action="details/%{#student.getUserId()}">
                                        <s:property value="#student.getFirstName()" /> <s:property value="#student.getLastName()" />
                                    </s:a>
                                </td>
                                <td><s:property value="#student.getImmatriculationNumber()" /></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </section>
            <section id="deliverables">
                <h3>Delivered Files</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Deliverable Name</th>
                            <th>File</th>
                            <th>Score</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iterator on delivered files -->
                        <tr>
                            <th colspan="3">
                                <div class="alert">
                                    No submitted files.
                                </div>
                            </th>
                        </tr>
                    </tbody>
                </table>
            </section>
        </div><!--/span-->
    </div><!--/row-->
    
    <%@include file="../components/footer.jsp" %>