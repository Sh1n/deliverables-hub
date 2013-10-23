<%-- 
    Document   : signup
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
    
         <div class="contentcontainer med left">
            <div class="headings altheading">
                <h2><s:text name="label.student_registration" /></h2>
            </div>
            <div class="contentbox">
                <s:form method="post" namespace="/students" action="signup">
            	    <p>
                        <label for="textfield"><strong><s:text name="insert.username" /></strong></label>
                        <input type="text" id="textfield" name="username" class="inputbox" /> <br />
                        <span class="smltxt">(This is an example of a small descriptive text for input)</span>
                    </p>
                    <p>
                        <label for="textfield"><strong><s:text name="insert.email" /></strong></label>
                        <input type="text" id="textfield" name="email" class="inputbox" /> <br />
                        <span class="smltxt">(This is an example of a small descriptive text for input)</span>
                    </p>
                    <p>
                        <label for="textfield"><strong><s:text name="insert.password" /></strong></label>
                        <input type="text" id="textfield" name="password" class="inputbox" /> <br />
                        <span class="smltxt">(This is an example of a small descriptive text for input)</span>
                    </p>
                    <p>
                        <label for="errorbox"><span class="red"><strong><s:text name="insert.firstName" /></strong></span></label>
                        <input type="text" id="errorbox" class="inputbox errorbox" name="firstName" /> <img src="img/icons/icon_missing.png" alt="Error" /> <br />
                        <span class="smltxt red">(This is some warning text for the above field)</span>
                    </p>
                    <p>
                        <label for="correctbox"><span class="green"><strong><s:text name="insert.lastName" /></strong></span></label>
                        <input type="text" id="correctbox" class="inputbox correctbox" name="lastName" /> <img src="img/icons/icon_approve.png" alt="Approve" />
                    </p>
                    <p>
                        <label for="smallbox"><strong><s:text name="insert.matriculationNumber" /></strong></label>
                        <input type="text" id="smallbox" name="matriculationNumber" class="inputbox smallbox" />
                    </p>
                    <input type="submit" value="Submit" class="btn" />
                </s:form>       
	    </div>
        </div>
        
        <div style="clear:both;"></div>
		
    </div>
    <!-- Right Side/Main Content End -->
    
    <%@include file="../parts/sidebar.jsp" %>
    
    <%@include file="../parts/footer.jsp" %>
    
</body>

</html>