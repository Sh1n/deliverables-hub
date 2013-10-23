<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ include file="components/header.jsp" %>

    <div class="container">
        <s:form theme="bootstrap" cssClass="form-search well" action="login" namespace="/auth" method="post" validate="true">
            <h3>Deliverables Hub::Login</h3>
            <br />
            <s:if test="hasActionErrors()">
                <s:actionerror theme="bootstrap"/>
    
            </s:if>
            <s:textfield name="email" placeholder="Email" value="sh1n@live.it"/>
            <s:password name="password" placeholder="Password" value="idkfa88"/>
            <s:a namespace="/students" action="signup" cssClass="btn btn-info"><s:text name="menu_item.signup"/></s:a>
            <s:submit name="formSubmit" cssClass="btn btn-primary btn-loading" data-loading-text="Loading..." value="Login"/>
            <!--
            <input type="text" name="email" class="input-small" placeholder="Email" />
            <input type="password" name="password" class="input-small" placeholder="Password" />
            <label class="checkbox">
                <input type="checkbox" /> Remember me
            </label>
            <a href="<s:url value="/students/signup" />" class="btn btn-info"><s:text name="menu_item.signup"/></a>
            <button type="submit" name="loginSubmit" class="btn btn-primary btn-loading" data-loading-text="Loading...">Login</button>
            -->
        </s:form>
      
    <%@ include file="components/footer.jsp" %>      
    
    