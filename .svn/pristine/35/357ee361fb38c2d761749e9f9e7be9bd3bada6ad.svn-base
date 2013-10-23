<%-- 
    Document   : view
    Created on : 14-nov-2011, 11.20.45
    Author     : Francesco Bux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Map" %>  
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
            <div class="headings alt">
                <h2><s:property value="course.NAME" /></h2>
            </div>
            <div class="contentbox">
                <p><s:property value="course.DESCRIPTION" /></p>
            </div>
        </div>
        <!-- Content Box End -->
        
        <div class="contentcontainer sml right">
            <div class="headings altheading">
                <h2>Actions</h2>
            </div>
            <div class="contentbox">
                <input type="submit" value="Attend Course" class="btn" />
                <hr />
                Score: 	NP
                <hr />
                Team : <input type="submit" value="Create" class="btn" /><input type="submit" value="Join" class="btnalt" />
            </div>
        </div>
		
        <div style="clear:both"></div>
	
        <!-- Alternative Content Box Start -->
		
        <div class="contentcontainer tabs">
            <div class="headings altheading">
                <h2 class="left">Deliverables</h2>
                <ul class="smltabs">
                    <li><a href="#deliveredList">List</a></li>
                    <li><a href="#newDeliverable">Add</a></li>
                </ul>
            </div>
            <div class="contentbox accordion" id="deliveredList">
                <s:iterator value="course.DELIVERABLES" var="deliverable">
                <h3>
                    <a href="#">
                        <div style="float:left">
                            <s:property value="deliverable.NAME" />
                        </div>
                        <div style="float:right">
                            Deadline : <s:property value="deliverable.DEADLINE" />
                        </div>
                    </a>
                    <div style="clear:both; display:block; visibility:hidden">&nbsp;</div>
                </h3>
                <div>
                    <p><s:property value="deliverable.DESCRIPTION" /></p>
                        <div style="float:left;">
                                <h4>File</h4> zrchdive.zip
                        </div>
                        <div style="float:right;">
                                <h4>Score</h4> 8/10
                        </div>
                        <div style="clear:both; display:block; visibility:hidden">&nbsp;</div>

                        <div class="spacer"></div>
                </div>
                </s:iterator>
				<h3>
					<a href="#">
						<div style="float:left">
							Deliverable 2
						</div>
						<div style="float:right">
							Deadline : 15/5/2013
						</div>
					</a>
					<div style="clear:both; display:block; visibility:hidden">&nbsp;</div>
				
				</h3>
				<div>
					<p>
					Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
					purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
					velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
					suscipit faucibus urna.
					</p>
					<h4>File</h4>
					<input type="file" id="uploader" /> <img src="img/loading.gif" alt="Loading" /> Uploading...
					<div class="spacer"></div>
				</div>
				
				<h3>
					<a href="#">
						<div style="float:left">
							Deliverable 2 Professor View
						</div>
						<div style="float:right">
							Deadline : 15/5/2013
						</div>
					</a>
					<div style="clear:both; display:block; visibility:hidden">&nbsp;</div>
				
				</h3>
				<div>
					<p>
					Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
					purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
					velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
					suscipit faucibus urna.
					</p>
					<table width="100%">
						<thead>
							<tr>
								<th>File</th>
								<th>Group</th>
								<th>Score</th>
								<th><input name="" type="checkbox" value="" id="checkboxall" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>archive.rar</td>
								<td>#1</td>
								<td>9/10 <a href="#" title=""><img src="img/icons/icon_edit.png" alt="Note" /></a></td>
								<td><input type="checkbox" value="" name="checkall" /></td>
							</tr>
							<tr class="alt">
								<td>archive.zip</td>
								<td>#2</td>
								<td><a onclick="$('#evaluate').bPopup(); return false;">Not Scored Yet!</a></td>
								<td><input type="checkbox" value="" name="checkall" /></td>
							</tr>
						</tbody>
					</table>
					<div class="extrabottom">
						<ul>
							<li><img src="img/icons/icon_edit.png" alt="Edit" /> Edit</li>
							<li><img src="img/icons/icon_approve.png" alt="Approve" /> Approve</li>
							<li><img src="img/icons/icon_unapprove.png" alt="Unapprove" /> Unapprove</li>
							<li><img src="img/icons/icon_delete.png" alt="Delete" /> Remove</li>
						</ul>
						<div class="bulkactions">
							<select>
								<option>Select bulk action...</option>
							</select>
							<input type="submit" value="Apply" class="btn" />
						</div>
					</div>
					<ul class="pagination">
						<li class="text">Previous</li>
						<li class="page"><a href="#" title="">1</a></li>
						<li><a href="#" title="">2</a></li>
						<li><a href="#" title="">3</a></li>
						<li><a href="#" title="">4</a></li>
						<li class="text"><a href="#" title="">Next</a></li>
					</ul>
					<div style="clear: both;"></div>
					<div class="spacer"></div>
				</div>
                </div>
            <div class="contentbox" id="newDeliverable">
                <form action="#">
                    <p>
                        <label for="textfield"><strong>Nome:</strong></label>
                        <input type="text" id="textfield" class="inputbox" name="deliverableName"/> <br />
                        <span class="smltxt">(This is an example of a small descriptive text for input)</span>
                    </p>
                    <p>
                        <label for="smallbox"><strong>Deadline field:</strong></label>
                        <input type="text" id="smallbox" name="deliverableDeadline" class="inputbox smallbox" />
                    </p>      
                    <label for="wysiwyg"><strong>Description:</strong></label>
                    <textarea class="text-input textarea" id="wysiwyg" name="deliverableDescription" rows="10" cols="75"></textarea>
                    <br />
                    <input type="submit" value="Add" name="deliverableCreate" class="btn" />
	        </form>         
            </div>	
        </div>
		
        <div class="contentcontainer">
            <div class="headings altheading">
                <h2>Teams</h2>
            </div>
            <div class="contentbox">
            	<table width="100%">
                    <thead>
                    	<tr>
                            <th>Name</th>
                            <th>Delivered Files</th>
                            <th>Team</th>
                            <th>Actions</th>
                            <th>Join</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<tr>
                            <td>Provolo</td>
                            <td>Download Archive</td>
                            <td>Check Members</td>
                            <td>
                            	<a href="#" title=""><img src="img/icons/icon_edit.png" alt="Edit" /></a>
                            	<a href="#" title=""><img src="img/icons/icon_approve.png" alt="Approve" /></a>
                                <a href="#" title=""><img src="img/icons/icon_unapprove.png" alt="Unapprove" /></a>
                                <a href="#" title=""><img src="img/icons/icon_delete.png" alt="Delete" /></a>
                            </td>
                            <td><input type="radio" value="teamid" name="teamjoin" /></td>
                        </tr>
                        <tr class="alt">
                        	<td>Trento</td>
                            <td>Download Archive</td>
							<td></td>
                            <td>
                            	<a href="#" title=""><img src="img/icons/icon_edit.png" alt="Edit" /></a>
                            	<a href="#" title=""><img src="img/icons/icon_approve.png" alt="Approve" /></a>
                                <a href="#" title=""><img src="img/icons/icon_unapprove.png" alt="Unapprove" /></a>
                                <a href="#" title=""><img src="img/icons/icon_delete.png" alt="Delete" /></a>
                            </td>
                            <td><input type="radio" value="" name="teamjoin" /></td>
                        </tr>
                        <tr>
                        	<td>Content Here</td>
                            <td>Lor</td>
							<td></td>
                            <td>
                            	<a href="#" title=""><img src="img/icons/icon_edit.png" alt="Edit" /></a>
                            	<a href="#" title=""><img src="img/icons/icon_approve.png" alt="Approve" /></a>
                                <a href="#" title=""><img src="img/icons/icon_unapprove.png" alt="Unapprove" /></a>
                                <a href="#" title=""><img src="img/icons/icon_delete.png" alt="Delete" /></a>
                            </td>
                            <td><input type="radio" value="" name="teamjoin" /></td>
                        </tr>
                         <tr class="alt">
                        	<td>Content Here</td>
                            <td>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam.</td>
							<td></td>
                            <td>
                            	<a href="#" title="Grant View Permission" class="popup"><img src="img/icons/icon_edit.png" alt="Edit" /></a>
                            	<a href="#" title=""><img src="img/icons/icon_approve.png" alt="Approve" /></a>
                                <a href="#" title=""><img src="img/icons/icon_unapprove.png" alt="Unapprove" /></a>
                                <a href="#" title=""><img src="img/icons/icon_delete.png" alt="Delete" /></a>
                            </td>
                            <td><input type="radio" value="" name="teamjoin" /></td>
                        </tr>
                    </tbody>
                </table>
                <div class="extrabottom">
                	<ul>
                    	<li><img src="img/icons/icon_edit.png" alt="Edit" /> <a onclick="$('#permission').bPopup(); return false;">Grant View Permission</a></li>
                        <li><img src="img/icons/icon_approve.png" alt="Approve" /> Approve</li>
                        <li><img src="img/icons/icon_unapprove.png" alt="Unapprove" /> Unapprove</li>
                        <li><img src="img/icons/icon_delete.png" alt="Delete" /> Remove</li>
						<li><img src="img/icons/icon_delete.png" alt="Delete" /> <a onclick="$('#score').bPopup(); return false;">Score</a></li>
                    </ul>
                    <div class="bulkactions">
                    	<input type="submit" value="Join Team" class="btnalt" />
                    </div>
                </div>
                <ul class="pagination">
                	<li class="text">Previous</li>
                    <li class="page"><a href="#" title="">1</a></li>
                    <li><a href="#" title="">2</a></li>
                    <li><a href="#" title="">3</a></li>
                    <li><a href="#" title="">4</a></li>
                    <li class="text"><a href="#" title="">Next</a></li>
                </ul>
                <div style="clear: both;"></div>
            </div>
            
        </div>
            
            <div style="clear:both;"></div>
         
            <!-- Content Box End -->
            <div id="footer">
                    &copy; Deliverables Hub - <a href="#">Web Architectures 2011/2012</a> @ <a href="www.unitn.it">Unitn</a> - <a href="http://www.linkedin.com/in/francescobux">Francesco Bux</a> - <a href="	http://devilerableshub.blogspot.com/">Development Blog</a> - Home - Logout
            </div>    
            
            
            
            
        </div>	
        
    <!-- Right Side/Main Content End -->
    
    <%@include file="../parts/sidebar.jsp" %>
    
    <%@include file="../parts/footer.jsp" %>
    
</body>

</html>