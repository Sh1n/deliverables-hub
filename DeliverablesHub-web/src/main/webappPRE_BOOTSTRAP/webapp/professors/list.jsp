<%-- 
    Document   : Professor List
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                    <h2>Professor List</h2>
                </div>
                <div class="contentbox">
                    <table width="100%">
                	<thead>
                            <tr>
                                <th>Name</th>
                                <th>Courses Held</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody class="professorsList">
                            <s:iterator value="professorList" var="prof">
                                <tr>
                                    <td><s:property value="#prof.getLastName()" /> <s:property value="#prof.getFirstName()" /></a></td>
                                    <td><s:property value="#prof.getCoursesHeld().size()" /></td>
                                    <td>
                                        <a href="#" onclick="$('body').coursesHeldPopup({professorId: <s:property value="#prof.getProfessorId()" />, url : '<s:url value="/professors/courses_held/" />'}); return false;" title=""><img src="<s:url value="/assets/images/icons/report.png"/>" alt="Courses Held" /></a>
                                        <a href="<s:url value="/professors/details/%{#prof.getProfessorId()}"/>"><img src="<s:url value="/assets/images/icons/pencil.png"/>" alt="Edit" /></a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <div class="extrabottom">
                        <ul>
                            <li><img src="<s:url value="/assets/images/icons/report.png"/>" alt="Courses Held" />Courses Held</li>
                            <li><img src="<s:url value="/assets/images/icons/pencil.png"/>" alt="Edit" />Edit Professor</li>
                        </ul>
                    </div>
                        <!--
                    <ul class="pagination">
                        <li class="text">Previous</li>
                        <li class="page"><a href="#" title="">1</a></li>
                        <li><a href="#" title="">2</a></li>
                        <li><a href="#" title="">3</a></li>
                        <li><a href="#" title="">4</a></li>
                        <li class="text"><a href="#" title="">Next</a></li>
                    </ul> -->
                    <div style="clear: both;"></div>
                </div>
            </div>
            <!-- Alternative Content Box End -->
            
            <div class="contentcontainer sml right">
                <div class="headings">
                    <h2>Add Professor</h2>
                </div>
                <div class="contentbox">
                    <div id="ajaxResponse"></div>
                    <form action="add" id="add_professor" method="post">
                        <p>
                            <label for="emailAddress"><strong>E-Mail Address:</strong></label>
                            <input type="text" id="emailAddress" name="emailAddress" class="inputbox" />
                        </p>
                        <p>
                            <label for="firstName"><strong>First Name:</strong></label>
                            <input type="text" id="firstName" name="firstName" class="inputbox smallbox" />
                        </p>
                        <p>
                            <label for="lastName"><strong>Last Name:</strong></label>
                            <input type="text" id="lastName" name="lastName" class="inputbox smallbox" />
                        </p>
                        <input type="submit" name="addProfessor" value="Add Professor" class="btn" />
                    </form>         
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
    

    <script type="text/javascript">
        $(document).ready(function(){
            $("#add_professor").submit(function(){
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
                        $("tbody.professorsList").append('<tr>'+
                                                    '<td>'+ data.newProfessor.lastName+' '+ data.newProfessor.firstName +'</td>' +
                                                    '<td>'+data.newProfessor.coursesHeld+'</td>'+
                                                    '<td>'+
                                                        '<a href="#" onclick="$(\'body\').coursesHeldPopup({professorId: '+ data.newProfessor.professorId + ', url : \'<s:url value="/professors/courses_held/" />\'}); return false;" title=""><img src="<s:url value="/assets/images/icons/report.png"/>" alt="Courses Held" /></a>' +
                                                        '<a href="<s:url value="/professors/details/"/>'+data.newProfessor.professorId+'"><img src="<s:url value="/assets/images/icons/pencil.png"/>" alt="Edit" /></a>'+
                                                    +'</td></tr>');
                                    
                    }else
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'error'});
                }};   // post-submit callback
                $(this).ajaxSubmit(options); 
                return false;
            });
        });
    </script>
    </body>
</html>