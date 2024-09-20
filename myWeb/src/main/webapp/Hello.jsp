<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int a = 100; %> <%//成員變數%>
	<% int a = 500; %> <%//區域變數%>
	<% out.println("a = "+a); %>
	a = <%= a/0 %> <br/>
	Current Time is : <%= SimpleDateFormat.getInstance().format(new Date()) %><br/>
	<!--  HTML Comment -->
	<%//Java single line comment --%>
	<%--JSP comment --%>
	
	User-Agent:<%= request.getHeader("User-Agent") %> <br/>
	User-Agent:<% out.println(request.getHeader("User-Agent")); %> <br/>
	User-Agent: ${ header["User-Agent"]}
	
</body>
</html>