<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%! String val = "Hola mundo desde String"; %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Hola mundo</p>
<p>La fecha en el servidor es <%=new java.util.Date() %></p>
<h2><%=val%></h2>
</body>
</html>

