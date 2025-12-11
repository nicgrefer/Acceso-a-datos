<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ServletAlumnos" method="get">
		
		<table align="center" border="2">
			<tr>
			<td colspan="4">GESTIÓN ALUMNOS</td>
			</tr>
			<tr>
			<td><input type="submit" name="boton" value="Alta" /></td>
			<td><input type="submit" name="boton" value="Baja" /></td>
			<td><input type="submit" name="boton" value="Actualiza" /></td>
			<td><input type="submit" name="boton" value="Consulta" /></td>
			</tr>
			<tr><td>${mensaje}</td></tr>
		</table></form>
</body>
</html>