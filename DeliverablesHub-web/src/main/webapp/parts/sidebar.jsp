<%-- 
    Document   : sidebar
    Created on : 26-dic-2011, 16.14.07
    Author     : Francesco Bux
    This page will create the left side bar. In order to display proper items, session variables will be accessed
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!--
    logged
    role
    namespace
    action
-->

<!-- Left Dark Bar Start -->
    <div id="leftside">
    	<div class="user">
            <!--
            <s:property value="#session.logged_token" />
            <s:property value="#session.namespace" />
            <s:property value="#session.action" />
            -->
            
            <s:if test="#session.logged_token == true">
                <img src="<s:url value="/assets/images/avatar.png"/>" width="44" height="44" class="hoverimg" alt="Avatar" />
                <p>Logged in as:</p>
                <p class="username"><s:property value="#session.role_token" /></p>
                <p class="userbtn"><s:a namespace="/auth" action="profile">Profile</s:a></p>
                <p class="userbtn"><s:a namespace="/auth" action="logout">Log out</s:a></p>
            </s:if>
            <s:else>
                <p>&nbsp;</p>
                <p class="username">&nbsp;</p>
                <p class="userbtn">&nbsp;</p>
            </s:else>
        </div>
	<!--
        <div class="notifications">
        	<p class="notifycount"><a href="" title="" class="notifypop">10</a></p>
            <p><a href="" title="" class="notifypop">New Notifications</a></p>
            <p class="smltxt">(Click to open notifications)</p>
        </div>
        -->
        <ul id="nav">
            <s:iterator status="stat" value="#session.menu_items" >
                <li>
                    <a class="<s:if test="#session.namespace != value.namespace">collapsed</s:if> heading"><s:text name="%{'menu_head'}.%{key}" /></a>
                    <ul class="navigation">
                        <s:set name="namespace" value="value.namespace"/>
                        <s:iterator value="value.elements">
                            <s:if test="value.viewable == true">
                                <s:if test="%{key == session.action && namespace == session.namespace}">
                                        <li class="heading selected"><s:text name="%{'menu_item'}.%{key}" /></li>
                                </s:if>
                                <s:else>
                                    <li><s:a action="%{key}" namespace="%{namespace}"><s:text name="%{'menu_item'}.%{key}" /></s:a></li>
                                </s:else>
                            </s:if>
                        </s:iterator>
                    </ul>
                </li>
            </s:iterator> 
        </ul>
    </div>
    <!-- Left Dark Bar End --> 
    