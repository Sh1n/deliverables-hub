<%-- 
    Document   : Navbar Part
    Created on : 12-aug-2012, 17.41.24
    Author     : Francesco Bux
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Deliverables Hub</a>
            <s:if test="#session.logged_token == true">
                <div class="btn-group pull-right">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="icon-user"></i> <s:property value="#session.role_token" />
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><s:a namespace="/auth" action="profile">Profile</s:a></li>
                        <li class="divider"></li>
                        <li><s:a namespace="/auth" action="logout">Sign Out</s:a></li>
                    </ul>
                </div>
            </s:if>
        </div>
    </div>
</div>