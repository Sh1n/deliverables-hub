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
            <h2>Professor Details - <s:property value="#professor.getLastName()" /> <s:property value="#professor.getFirstName()" /></h2>
            <s:form namespace="/professors" cssClass="form-horizontal well" action="details/%{#professor.getProfessorId()}" id="edit_professor" validate="true" theme="bootstrap" method="post">
                <s:actionerror theme="bootstrap"/>
                <s:actionmessage theme="bootstrap"/>
                <s:textfield label="First Name" name="firstName" value="%{#professor.getFirstName()}" id="firstName"/>
                <s:textfield label="Last name" name="lastName" value="%{#professor.getLastName()}" id="lastName" />
                <s:textfield label="Email Address" name="emailAddress" value="%{#professor.getEmail()}" id="emailAddress"/>
                <s:password label="New Password" name="password" tooltip="Write to change" />
                <div class="form-actions">
                    <s:submit name="formSubmit" cssClass="btn btn-primary btn-loading" data-loading-text="Sending Data..." value="Add"/>
                </div>
            </s:form>
            <hr />
            <h2>Held Courses</h2>
            <div class="well">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
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
                                        <a href="<s:url value="courses/details/%{course.getId()}" />" title="Course Page" class="btn btn-info"><i class="icon-align-justify"></i></a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <tr>
                                <td colspan="4"><div class="alert alert-info">There are no courses held by the professor</div></td>
                            </tr>
                        </s:else>
                    </tbody>
                </table>
            </div>
        </div><!--/span-->
    </div><!--/row-->
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
    <%@include file="../components/footer.jsp" %>