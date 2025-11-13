<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Alta Incidencia</title>
</head>
<body>
	<h1>ALTA INCIDENCIA</h1>
	<form action="ServletIncidencia" method="post">
	<%
		if (request.getAttribute("codigoInc") == null)
		{
	%>
	<table>
		<tr>
			<td><label>Tema: </label></td>
			<td><input type='text' name='tema' value=""></td>
		</tr>
		<tr>
			<td><label>Descripción: </label></td>
			<td><textarea name='descripcion' rows="4" cols="50"></textarea></td>
		</tr>
	</table>
	<%
		if (request.getAttribute("error") != null)
		{%>
			<p style="color: red;">(*) El tema y la descripción son obligatorios</p>
		<% }%>
	
	<input type='submit' name='boton' value='Confirmar'/>
	<%
		}
		else if (request.getAttribute("codigoInc")!=null && Integer.valueOf(request.getAttribute("codigoInc").toString())>0)
		{%>
		<p align='center'>Su incidencia ha sido dada de alta en nuestro sistema con el código:</p>
	    <h3 align='center'> ${codigoInc}</h3>
	
	<input type='submit' name='boton' value='Consultar'/> 
	<%
		} else if(Integer.valueOf(request.getAttribute("codigoInc").toString())==0){
	%>
	<p align="center">Tiene que esperar a que se resuelvan incidencias.</p>
	<%} %>
	</form>
</body>
</html>