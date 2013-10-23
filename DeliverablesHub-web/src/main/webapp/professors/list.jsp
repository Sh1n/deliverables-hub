<%-- 
    Document   : Professor List
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ include file="../components/header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@include  file="../components/sidebar.jsp" %>
        <div class="span9">
            <div class="tabbable tabs-right">
                <ul class="nav-tabs nav">
                    <li class="active"><a data-toggle="tab" href="#professors_list"><s:text name="professors.list" /></a></li>
                    <li><a data-toggle="tab" href="#add_professor"><s:text name="professors.add" /></a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="professors_list">
                        <h2><s:text name="professors.list"/></h2>
                        <s:actionerror theme="bootstrap"/>
                        <s:actionmessage theme="bootstrap"/>
                        <table width="100%" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th><s:text name="name" /></th>
                                    <th><s:text name="professors.held_courses" /></th>
                                    <th><s:text name="actions"/></th>
                                </tr>
                            </thead>
                            <tbody class="professorsList">
                                <s:iterator value="professorList" var="prof">
                                <tr>
                                    <td>
                                        <s:property value="#prof.getFirstName()" /> <s:property value="#prof.getLastName()" /> 
                                    </td>
                                    <td>
                                        <s:property value="#prof.getCoursesHeld().size()" />
                                    </td>
                                    <td>
                                        <div class="btn-group">
                                            <a data-toggle="modal" href="<s:url namespace="/professors" action="heldcourses/%{#prof.getProfessorId()}"/>" data-target="#heldCoursesModal" role="button" class="btn btn-info"><i class="icon-align-justify"></i></a>
                                            <a href="<s:url value="/professors/details/%{#prof.getProfessorId()}" />" class="btn btn-info" rel="tooltip" title="<s:text name="professors.held_courses"/>"><i class="icon-user"></i></a>
                                        </div>
                                    </td>
                                </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                        <div id="heldCoursesModal" class="modal" style="display:none;" aria-labelledby="modalLabel" aria-hidden="true">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h3 id="modalLabel">Held Courses</h3>
                            </div>
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            </div>
                        </div>        
                    </div>
                    <div class="tab-pane" id="add_professor">
                        <h2><s:text name="professors.add"/></h2>
                        
                       
                        <s:form namespace="/professors" cssClass="form-horizontal well" action="list" id="add_professor" theme="bootstrap" method="post">
                            <s:if test="hasActionErrors()">
                                <s:actionerror theme="bootstrap"/>
                            </s:if>
                            <s:textfield label="Email Address" name="emailAddress" id="emailAddress" />
                            <s:textfield label="First Name" name="firstName" id="firstName" />
                            <s:textfield label="Last Name" name="lastName" id="lastName" />
                            <div class="form-actions">
                                <s:submit name="formSubmit" cssClass="btn btn-primary btn-loading" data-loading-text="Sending Data..." value="Add" formIds="add_professor" />
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
            
     
            
        </div><!--/span-->
    </div><!--/row-->
     <script type="text/javascript">
        $(document).ready(function(){
              $("deactivated#add_professor").ajaxForm({
                dataType:      'json',
                type: 'POST',
                url:    '<s:url namespace="/professors" action="add" />',
                beforeSubmit:  function(arr, $form, options){
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
                    if(!status)
                        return false;
                },
                success: function(data)  { 
                    alert("Successfull submission with " + data.status);
                    if(data.status == 'ajax_success'){
                        
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'alert-success'});
                        $("tbody.professorsList").append('<tr>'+
                                                    '<td>'+ data.newProfessor.firstName+' '+ data.newProfessor.lastName +'</td>' +
                                                    '<td>0</td>'+
                                                    '<td><div class="btn-group">'+
                                                        '<a data-toggle="modal" href="<s:url namespace="/professors" action="details/'+ data.newProfessor.userId + '"/>" data-target="#heldCoursesModal" role="button" class="btn btn-info"><i class="icon-align-justify"></i></a>'+
                                                        '<a href="<s:url value="/professors/details/'+ data.newProfessor.userId + '"/>" class="btn btn-info" rel="tooltip" title="<s:text name="professors.held_courses"/>"><i class="icon-user"></i></a>'+
                                                        '</div>'+
                                                    '</td></tr>');
                                    
                    }else
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'alert-error'});
                    $("#lastName").updateFieldStatus({status: ''});
                    $("#firstName").updateFieldStatus({status: ''});
                    $("#emailAddress").updateFieldStatus({status: ''});
                }
                
            });
        });
    </script>
    <%@include file="../components/footer.jsp" %>
   