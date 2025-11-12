<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ejemplo paguina error</h1>
<% if (exception != null){
	out.print("se esperaba que introduguiese un numero por parametro ejem ...?num=x ");
	//exception.printStackTrace(new PrintWriter(out));
}
	
	
%>
</body>
</html>