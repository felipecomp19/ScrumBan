<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="viewModel.*"%>
<%@page import="model.*"%>
<jsp:useBean id="userVM" type="viewModel.UserViewModel" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../shared/head.jsp" %>

<body>
	<%@include file="../shared/navbar.jsp" %>
	<form method="POST" action="saveUser.html">
		<% if (userVM.getUser().getId() != null) { %>
			<input type="hidden" name="id" value="<%= userVM.getUser().getId() %>" />
			Name: <input type="text" name="name" value="<%= userVM.getUser().getName() %>" /> 
			Email: <input type="text" name="email" value="<%= userVM.getUser().getEmail() %>" /> 
			Password <input type="password" name="pwd" value="<%= userVM.getUser().getPassword() %>" />
		<%}else{ %>
		 	Name: <input type="text" name="name"  /> 
			Email: <input type="text" name="email" /> 
			Password <input type="password" name="pwd" />
		<%} %>
		
		<input type="submit" value="Save">
	</form>

	<hr>
	<ol>
		<%
			for (UserModel user : userVM.getUserList()) {
		%>
			<li><%= user %> 
				<a href="editUser.html?id= <%= user.getId() %> ">edit</a>
				<a href="deleteUser.html?id= <%= user.getId() %> ">delete</a>
			</li>
		<% } %>
	</ol>
	<hr>
</body>
</html>