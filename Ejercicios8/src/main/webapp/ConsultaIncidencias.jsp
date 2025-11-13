<%@page import="model.Incidencia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList <Incidencia> list = (ArrayList)application.getAttribute("listInc");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Codigo</td>
		<td>Tema</td>
		<td>Descripción</td>
	</tr>
	<tr>
		<%for (Incidencia inc : list ) {%>
		<td><%=inc.getCodigo() %></td>
		<td><%=inc.getTema() %></td>
		<td><%=inc.getDescripcion() %></td>
	</tr> <%}%>
</table>
<form action="ServletIncidencia" method="post">
	<input type="submit" name="boton" value="Volver"/>
</form>
</body>
</html>