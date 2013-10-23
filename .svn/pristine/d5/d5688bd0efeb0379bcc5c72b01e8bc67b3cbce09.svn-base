<%-- 
    Document   : signup
    Created on : 14-nov-2011, 11.20.30
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ include file="../components/header.jsp" %>
    
    <div class="container">
        <div class="row">
            <div class="span8">
                <s:form theme="bootstrap" cssClass="well form-horizontal" action="signup" namespace="/students" method="post" validate="true">
                    <h2>Student Signup</h2>
                    <s:textfield name="email" label="Email Address" />
                    <s:password name="password" label="Password" />
                    <s:textfield name="firstName" label="First Name" />
                    <s:textfield name="lastName" label="Last Name" />
                    <s:textfield name="immatriculationNumber" label="Immatriculation Number" />
                    <!--
                    <div class="control-group">
                        <label class="control-label" for="input01">Email Address</label>
                        <div class="controls">
                            <div class="input-prepend">
                                <span class="add-on">
                                    <i class="icon-envelope"></i>
                                </span>
                                <input type="email" name="email" class="input-xlarge" id="input01">
                            </div>
                            <p class="help-block">Insert a valid email</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input02">Password</label>
                        <div class="controls">
                            <input type="password" name="password" class="input-xlarge" id="input02" />
                            <p class="help-block">Insert an alphanumeric 8 chars long password</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input03">First Name</label>
                        <div class="controls">
                            <input type="text" name="firstName" class="input-xlarge" id="input03" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input04">Last Name</label>
                        <div class="controls">
                            <input type="text" name="lastName" class="input-xlarge" id="input04" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input05">Immatriculation Number</label>
                        <div class="controls">
                            <input type="text" name="immatriculationNumber" class="input-xlarge" id="input05" />
                        </div>
                    </div>
                    -->
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary btn-loading" name="formSubmit" data-loading-text="Sending Data...">Sign Up</button>
                    </div>
                    </s:form>
                </div>
                <div class="span4">
                    <s:form cssClass="well form-vertical" action="login" namespace="/auth" method="post">
                        <h3>Deliverables Hub::Login</h3>
                        <br />
                        <s:if test="hasActionErrors()">
                            <div class="alert alert-error">
                                <p><s:actionerror/></p>
                            </div>
                        </s:if>

                        <input type="text" name="email" class="input-small" placeholder="Email" />
                        <input type="password" name="password" class="input-small" placeholder="Password" />
                        <label class="checkbox">
                            <input type="checkbox" /> Remember me
                        </label>
                        
                        <button type="submit" name="formSubmit" class="btn btn-primary btn-loading" data-loading-text="Loading...">Login</button>
                    </s:form>
                </div>
            </div>
    
    <%@ include file="../components/footer.jsp" %>
    
 