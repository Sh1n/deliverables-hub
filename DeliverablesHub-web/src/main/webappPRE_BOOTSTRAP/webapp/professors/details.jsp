<%-- 
    Document   : Professor Details
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

            <div class="contentcontainer sml left">
                <div class="headings altheading">
                    <h2>Professor Details - <s:property value="professor.getLastName()" /> <s:property value="professor.getFirstName()" /></h2>
                </div>
                <div class="contentbox">
                    <div id="ajaxResponse"></div>
                    <form action="<s:url value="/professors/edit" />" id="edit_professor" method="post">
                        <p>
                            <label for="firstName"><strong>First Name:</strong></label>
                            <input type="text" id="firstName" value="<s:property value="professor.getFirstName()" />" class="inputbox smallbox" />
                        </p>
                        <p>
                            <label for="lastName"><strong>Last Name:</strong></label>
                            <input type="text" id="lastName" value="<s:property value="professor.getLastName()" />" class="inputbox smallbox" />
                        </p>
                        <p>
                            <label for="emailAddress"><strong>EMail Address:</strong></label>
                            <input type="text" id="emailAddress" value="<s:property value="professor.getEmailAddress()" />"class="inputbox" />
                        </p>
                        <p>
                            <label for="password"><strong>Password:</strong></label>
                            <input type="text" id="password" value=""class="inputbox" /><br />
                            <span class="smltxt">(Write to change the password)</span>
                        </p>
                        <input type="hidden" name="professorId" value="<s:property value="professor.getProfessorId()" />" />
                            <input type="submit" value="Edit" class="btn" />
                    </form>
                </div>
            </div>
        
            <div class="contentcontainer med right">
                <div class="headings">
                    <h2>Held Courses</h2>
                </div>
                <div class="contentbox">
                    <table width="100%">
                        <thead>
                            <tr>
                                <th>Name</th<>
                                <th>Year</th>
                                <th>Sector</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:if test="professor.getCoursesHeld().size() > 0">
                                <s:iterator value="professor.getCoursesHeld()" var="course">
                                    <tr>
                                        <td><s:property value="course.getName()" /></td>
                                        <td><s:property value="course.getYear()" /></td>
                                        <td><s:property value="course.getSector()" /></td>
                                        <td>
                                            <a href="<s:url value="courses/details/{course.getId()}" />" title="Course Page"><img src="<s:url value="assets/images/icons/details.png"/>" alt="Details" /></a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </s:if>
                            <s:else>
                                <tr>
                                    <td colspan="4"><div class="status info">There are no courses held by the professor</div></td>
                                </tr>
                            </s:else>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <div style="clear:both;"></div>
         
            <!-- Content Box End -->
            <div id="footer">
                    &copy; Deliverables Hub - <a href="#">Web Architectures 2011/2012</a> @ <a href="www.unitn.it">Unitn</a> - <a href="http://www.linkedin.com/in/francescobux">Francesco Bux</a> - <a href="	http://devilerableshub.blogspot.com/">Development Blog</a> - Home - Logout
            </div>    
            
        </div>	
        
    <!-- Right Side/Main Content End -->
    
    <%@include file="../parts/sidebar.jsp" %>
    
    <%@include file="../parts/footer.jsp" %>
    
</body>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#edit_professor").submit(function(){
                var options = { 
                dataType:      'json', 
                type:      'POST',
                clearForm:  true,
                beforeSubmit:  function(){
                    var status = true;
                    if($("#emailAddress").validateField({required: true, email: true}))
                        $("#emailAddress").updateFieldStatus({status: 'correct'});
                    else{
                        $("#emailAddress").updateFieldStatus({status: 'error', message:'A valid email address is required'});
                        status &= false;
                    }

                    if($("#firstName").validateField({required: true}))
                        $("#firstName").updateFieldStatus({status: 'correct'});
                    else{
                        $("#firstName").updateFieldStatus({status: 'error', message:'Required field'});
                        status &= false;
                    }

                    if($("#lastName").validateField({required: true}))
                        $("#lastName").updateFieldStatus({status: 'correct'});
                    else{
                        $("#lastName").updateFieldStatus({status: 'error', message:'Required field'});
                        status &= false;
                    }
                    return status == 0 ? false : true;
                },  // pre-submit callback 
                success: function(data)  { 
                    if(data.status == 'ajax_success'){
                        $("#lastName").updateFieldStatus({status: ''});
                        $("#firstName").updateFieldStatus({status: ''});
                        $("#emailAddress").updateFieldStatus({status: ''});
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'success'});
                    }else
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'error'});
                }};   // post-submit callback
                $(this).ajaxSubmit(options); 
                return false;
            });
        });
    </script>

</html>