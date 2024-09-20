<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="myStyle/style.css" rel="stylesheet"></link>
</head>
<body>
	<h1>Welcome</h1>
	<p>Current time is : <%= SimpleDateFormat.getInstance().format(new Date()) %> </p>
	<p><a href="admin/hello.aspx">Hello Servlet</a></p>
	<p><a href="admin/Dump.view">Dump Servlet</a></p>
	<p><a href="customer/createCustomer.jsp">Create Customer</a></p>
	<p><a href="Hello.jsp">EL & Error</a></p>
	<p><a href="admin/dump.jsp">Dump JSP</a></p>

</body>
</html>