<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="Edit.EditForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX based CRUD operations using jTable in Servlet and
	JSP</title>
<!-- Include one of jTable styles. -->
<link href="jtable.css" rel="stylesheet" type="text/css" />
<link href="jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
<!-- Include jTable script file. -->
<script src="jquery-1.8.2.js" type="text/javascript"></script>
<script src="jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="jquery.jtable.js" type="text/javascript"></script>
</head>
<body bgcolor="CCFFFF">
<%
	EditForm form = (EditForm) request.getAttribute("editForm");
	String action = (String) request.getAttribute("action");
%>
<form action="<%=action%>" method="post" id="editForm"
					name="Form">
	<div
		style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
		<h1 align="left" style="color: red;">Training</h1>
		<hr>
		<div id="center">
			<h3 align="left"">Login > Search Customer</h3>
			<div id="1">
				<table align="left">
					<tr>
						<td align="left"><h4>Wellcome</h4></td>
						<td align="right"><a href="login.jsp">Logout</a></td>
					</tr>
				</table>
			</div>
			<br> <br>
			<p style="border-top: 30px solid; color: blue; width: 100%;"></p>
			<div id="center"width="70%" height="25%" cellpadding="5" align="center"
					style="padding: 10%;font-weight:bold;">
				
				<table >
					<tr>
						<td>Customer Name:</td>
						<td><input type="text" size="42%" name="customerName" 
						<% if(form.getCustomerName() != null) {%>
						value="<%=form.getCustomerName()%>"
						<%} %>
						></td>
					</tr>
					<tr>
						<td>Sex:</td>
						<td align="left"><select name ="sex" >
								<option value=""></option>
								<option value="M"
								<% if(form.getSex() != null) {%>
								 <%= form.getSex().equals("M")? "selected":""%>
								 <%} %>
								 >M</option>
								<option value="F" 
								<% if(form.getSex() != null) {%>
								<%= form.equals("F")? "selected":""%>
								 <%} %>
								>F</option>
						</select></td>
					</tr>
					<tr>
						<td>Birthday:</td>
						<td><input type="text" size="42%"  name="birthDay"
						<% if(form.getBirthDay() != null) {%>
						 value="<%=form.getBirthDay()%>"
						  <%} %>
						 ></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" size="42%" name="email"
						<% if(form.getEmail() != null) {%>
						 value="<%=form.getEmail()%>"
						 <%} %>
						 ></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" style="padding: 7%;" size="35%;" name="address"
						<% if(form.getAddress() != null) {%>
						 value="<%=form.getAddress()%>"
						 <%} %>
						 ></td>
					</tr>
					<tr>
						<td></td>
							<td colspan="2" align="center"><input type="submit"
						value="Login"> <input type="button" id="reset"
						value="Clear"></td>
				</table>
			
			</div>
			<div id="footer" style="width: 100%;text-align: left;margin-top: 20%;">
				<hr>
				<label>Copy right@ 2000-2008 FUJINET, All Rights Reserved.</label>
			</div>

		</div>
			</form>
</body>
</html>
