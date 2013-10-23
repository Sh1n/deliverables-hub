<%-- 
    Document   : login
    Created on : 14-nov-2011, 10.45.36
    Author     : Francesco Bux
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@ include file="parts/header.jsp" %>
    <link href="<s:url value='/assets/css/styles/login.css' />" rel="stylesheet" type="text/css" />
    <body>
        
        <div id="logincontainer">
            <div id="loginbox">
                <div id="loginheader">
                    Deliverables Hub Login
                    <!--img src="themes/blue/img/cp_logo_login.png" alt="Control Panel Login" / -->
                </div>
                <div id="innerlogin">
                    <s:form action="login" namespace="/auth" method="post">
                        <p><s:text name="insert.email" /></p>
                        <input type="text" class="logininput" name="email" value="sh1n@live.it"/>
                        <p><s:text name="insert.password" /></p>
                        <input type="password" class="logininput" name="password" value="provola"/>
                        <input type="submit" name="loginSubmit" value="<s:text name='label.login' />" class="loginbtn" />
                        <br />
                        <p><a href="<s:url value='auth/forgotten_password' />" title="Forgotten Password?"><s:text name="label.forgotten_password" /></a></p>
                        <br />
                        <p><a href="<s:url namespace="/students" action="signup" />" title="Student Registration"><s:text name="label.student_registration" /></a></p>
                        <s:if test="hasActionErrors()">
                            <div class="status error">
                                <p><s:actionerror/></p>
                            </div>
                        </s:if>
                    </s:form>
                </div>
            </div>
            <img src="<s:url value='/assets/images/login_fade.png' />" alt="Fade" />
        </div>
    </body>
</html>