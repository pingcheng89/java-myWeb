<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/myStyle/style.css" rel="stylesheet">
</head>
<body>
	
	<h2>九九乘法表</h2>
	<table border='1' style='margin:auto'>
		<tbody>
			<% for(int i =1;i<=9;i++){
				out.println("<tr>");
				for(int j=1;j<=9;j++){
					out.println("<td>" + i + "*" + j + "=</td><td>" + i*j + "</td>");	
					}
				} %>
		</tbody>
	</table>
	<br/>
	<table border='1' style='margin:auto'>
		<tbody>
			<% for(int i =1;i<=9;i++){ %>
				<tr>
			<%for(int j=1;j<=9;j++){ %>
				<td><%= i %>*<%= j %>=</td>
				<td><%= i*j%></td>
				<%} %>
			<% } %>
		</tbody>
	</table>
	
	<h2>Header</h2>
	<% Enumeration<String> headerNames  = request.getHeaderNames(); %>
	<table border='1' style='margin:auto'>
		<thead><tr><th>Name</th><th>Value</th></tr></thead>
			<tbody>
			<% while(headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				out.println("<tr><td>"+headerName+"</td><td>"+headerValue+"</td></tr>");
	 		} %>
			</tbody>
	</table>
	<img src="../image/ghost.jpg"/>

</body>
</html>