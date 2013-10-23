<%-- 
    Document   : signup
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="java.util.Map" %>  
<!DOCTYPE html>
<html>
    <%@ include file="../parts/header.jsp" %>
    <link href="<s:url value='/assets/css/styles/login.css' />" rel="stylesheet" type="text/css" />
    <body id="homepage">
	<div id="header">
            &nbsp;
        </div>
        <%@include file="../parts/breadcrumb.jsp" %>
    
     
        <!-- Right Side/Main Content Start -->
        <div id="rightside">

            <!-- Alternative Content Box Start -->
            <div class="contentcontainer med left">
                <div class="headings altheading">
                    <h2>Courses List</h2>
                </div>
                <div class="contentbox">
                    <table width="100%">
                        <thead>
                            <tr>
                                <th>Course Name</th>
                                <th>Year</th>
                                <th>Sector</th>
                                <th>Code</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="coursesList">
                                <tr>
                                    <td><a href="view/<s:property value="key" />"><s:property value="value.NAME" /></a></td>
                                    <td><s:property value="value.getYear()" /></td>
                                    <td><s:property value="value.getSector()" /></td>
                                    <td><s:property value="value.getCode()" /></td>
                                    <td>
                                        <a href="view/<s:property value="key" />" title=""><img src="<s:url value="/assets/images/icons/report.png"/>" alt="Report" /></a>
                                        <a href="#" title=""><img src="<s:url value="/assets/images/icons/icon_delete.png"/>" alt="Delete" /></a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <div class="extrabottom">
                            <ul>
                            <li><img src="<s:url value="/assets/images/icons/report.png" />" alt="Details" /> Details</li>
                            <li><img src="<s:url value="/assets/images/icons/icon_delete.png" />" alt="Delete" /> Remove</li>
                        </ul>
                        
                    </div>
                    
                    <div style="clear: both;"></div>
                </div>

            </div>
            <!-- Alternative Content Box End -->

            <div class="contentcontainer sml right" id="tabs">
                <div class="headings">
                    <h2 class="left"><s:text name="courses.add_course" /></h2>
                </div>
                <div class="contentbox" id="tabs-1">
                    <s:if test="%{message!=null}">
                        <div class="status <s:property value="message.status" />">
                        <s:if test="%{message.closable}">
                            <p class="closestatus"><a href="" title="Close">x</a></p>
                        </s:if>    
                            <p><img src="<s:url value="assets/images/icons/icon_%{message.status}.png"/>" alt="<s:property value="%{message.status}"/>" /><s:property value="message.text" />.</p>
                        </div>
                    </s:if>
                    <s:form method="post" namespace="/courses" action="list" id="add_course">
                        <p>
                            <label for="textfield"><strong><s:text name="courses.insert_name" /></strong></label>
                            <input type="text" id="courseName" name="courseName" class="inputbox" /> <br />
                        </p>
                        <p>
                            <label for="textfield"><strong><s:text name="course.insert_year" /></strong></label>
                            <sj:datepicker id="courseYear" name="courseYear" label="course.insert_year" class="inputbox smallbox"/>
                            <input type="text" id="courseYear" name="courseYear" class="inputbox smallbox" /> <br />
                        </p>
                        <p>
                            <label for="textfield"><strong><s:text name="course.insert_code" /></strong></label>
                            <input type="text" id="courseCode" name="courseCode" class="inputbox smallbox" /> <br />
                        </p>
                        <p>
                            <label for="textfield"><strong><s:text name="course.insert_sector" /></strong></label>
                            <input type="text" id="courseSector" name="courseSector" class="inputbox smallbox" /> <br />
                        </p>
                        <input type="submit" value="<s:text name="courses.add" />" name="addCourse" class="btn" />
                    </s:form>
                    
                </div>
            </div>            
            
            
            <div style="clear:both;"></div>
            
            <%@include file="../parts/syndicate.jsp" %>
            <!-- Content Box End -->
                
        </div>	
        
    <!-- Right Side/Main Content End -->
    
    <%@include file="../parts/sidebar.jsp" %>
    
    <%@include file="../parts/footer.jsp" %>
    
    <script type="text/javascript">
        $(document).ready(function(){
            $("#add_course").submit(function(){
                var status = true;
                if($("#courseName").validateField({required: true, email: true}))
                    $("#courseName").updateFieldStatus({status: 'correct'});
                else{
                    $("#courseName").updateFieldStatus({status: 'error', message:'Required field'});
                    status &= false;
                }

                if($("#courseYear").validateField({required: true}))
                    $("#courseYear").updateFieldStatus({status: 'correct'});
                else{
                    $("#courseYear").updateFieldStatus({status: 'error', message:'Required field'});
                    status &= false;
                }

                if($("#courseSector").validateField({required: true}))
                    $("#courseSector").updateFieldStatus({status: 'correct'});
                else{
                    $("#courseSector").updateFieldStatus({status: 'error', message:'Required field'});
                    status &= false;
                }
                
                if($("#courseCode").validateField({required: true}))
                    $("#courseCode").updateFieldStatus({status: 'correct'});
                else{
                    $("#courseCode").updateFieldStatus({status: 'error', message:'Required field'});
                    status &= false;
                }
                return status == 0 ? false : true;
            });
        });
    </script>
    
</body>

</html>