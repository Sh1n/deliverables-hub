<%-- 
    Document   : Courses List
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
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#course_list" data-toggle="tab">Courses List</a></li>
                    <li><a href="#add_course" data-toggle="tab">Add Course</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="course_list">
                        <h2>Courses List</h2>
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Course Name</th>
                                    <th>Year</th>
                                    <th>Sector</th>
                                    <th>Code</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody class="coursesList">
                                <s:iterator value="coursesList" var="course">
                                    <tr>
                                        <td><a href="view/<s:property value="#course.getCourseId()" />"><s:property value="#course.getName()" /></a></td>
                                        <td><s:property value="#course.getYear()" /></td>
                                        <td><s:property value="#course.getSector()" /></td>
                                        <td><s:property value="#course.getCode()" /></td>
                                        <td>
                                            <div class="btn-toolbar">
                                                <a href="view/<s:property value="#course.getCourseId()" />" class="btn btn-info btn-mini" title=""><i class="icon-info-sign"></i></a>
                                                <a href="#" title="" class="btn btn-danger btn-mini"><i class="icon-trash"></i></a>
                                            </div>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="add_course">
                        <h2>Add Course</h2>
                        <s:form theme="bootstrap" cssClass="form-horizontal well" method="post" namespace="/courses" action="add" id="add_course">
                            <s:if test="hasActionErrors()">
                                <s:actionerror theme="bootstrap"/>
                            </s:if>
                            <s:textfield label="Course Name" name="courseName" id="courseName"/>
                            <s:textfield label="Course Year" name="courseYear" id="courseYear"/>
                            <s:textfield label="Course Sector" name="courseSector" id="courseSector"/>
                            <s:textfield label="Course Code" name="courseCode" id="courseCode"/>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary btn-loading" name="formSubmit" data-loading-text="Sending Data...">Add</button>
                            </div>
                        </s:form>
                    </div><!--/tab-pane-->
                </div><!--/tab-content-->
            </div><!--/tabbable-->
        </div><!--/span-->
    </div><!--/row-->
      <script type="text/javascript">
        $(document).ready(function(){
            $("form#add_course").ajaxForm({
                dataType:      'json',
                type: 'POST',
                beforeSubmit:  function(arr, $form, options){
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
                },
                success: function(data)  { 
                    alert("Successfull submission with " + data.status);
                    if(data.status == 'ajax_success'){
                        
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'alert-success'});
                        $("tbody.coursesList").append('<tr>'+
                                                    '<td><a href="<s:url value="courses/view"/>/' + data.newCourse.courseId + '">' + data.newCourse.name +'<a></td>' +
                                                    '<td>' + data.newCourse.year + '</td>'+
                                                    '<td>' + data.newCourse.sector + '</td>'+
                                                    '<td>' + data.newCourse.code + '</td>'+
                                                    '<td><div class="btn-group">'+
                                                        '<a href="view/' + data.newCourse.courseId + '" class="btn btn-info btn-mini" title=""><i class="icon-info-sign"></i></a>' +
                                                        '</div>'+
                                                    '</td></tr>');
                                    
                    }else
                        $("#ajaxResponse").message({message: data.responseMessage, status: 'alert-error'});
                    $("#courseYear").updateFieldStatus({status: ''});
                    $("#courseName").updateFieldStatus({status: ''});
                    $("#courseSector").updateFieldStatus({status: ''});
                    $("#courseCode").updateFieldStatus({status: ''});
                }
            });
        });
    </script>
    <%@ include file="../components/footer.jsp" %>
