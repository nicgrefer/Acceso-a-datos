<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="Ejemplo19Segundo.jsp">
	<jsp:param value="Hola mundo" name="arg3"/>
</jsp:forward>
</body>
</html>

<!-- http://localhost:8081/examapp/Ejemplo19Primero.jsp?arg1=hola&arg2=adios -->