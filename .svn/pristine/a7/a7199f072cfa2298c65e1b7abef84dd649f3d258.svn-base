<%-- 
    Document   : sidebar
    Created on : 26-dic-2011, 16.14.07
    Author     : Francesco Bux
    This page will create the left side bar. In order to display proper items, session variables will be accessed
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="span3">
    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            
            <s:iterator status="stat" value="#session.menu_items" >
                <li class="nav-header"><s:text name="%{'menu_head'}.%{key}" /></li>
                <s:set name="namespace" value="value.namespace"/>
                <s:iterator value="value.elements">
                    <s:if test="value.viewable == true">
                        <s:if test="%{key == session.action && namespace == session.namespace}">
                            <li class="active"><s:text name="%{'menu_item'}.%{key}" /></li>
                        </s:if>
                        <s:else>
                            <li><s:a action="%{key}" namespace="%{namespace}"><s:text name="%{'menu_item'}.%{key}" /></s:a></li>
                        </s:else>
                    </s:if>
                </s:iterator>
            </s:iterator>
        </ul>
    </div><!--/.well -->
</div><!--/span-->