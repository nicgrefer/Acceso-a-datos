<%@page import="mode.pojoPersona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
pojoPersona p = request.getAttribute("persona")!=null?(pojoPersona)request.getAttribute("persona"): new pojoPersona();;


%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletPersona" method="post">

	<h1>DAtos personales</h1>
	<table>
		<tr>
			<th>DNI:</th>
			<td><input type="text" name="dni" value="<%=p.getDni()!=null?p.getDni():"" %>" size="9" maxlength="9" disabled="disabled"/> </td>
		</tr>
		<tr>
			<th>Nombre:</th>
			<td><input type="text" name="nombre" value="<%=p.getNombre()!=null?p.getNombre():"" %>" size="20" maxlength="20" disabled="disabled"/> </td>
		</tr>
		<tr>
			<th>Apellidos:</th>
			<td><input type="text" name="apellido" value="<%=p.getApellidos()!=null?p.getApellidos():""  %>" size="20" maxlength="20" disabled="disabled"/> </td>
		</tr>
		<tr>
			<th>Direccion:</th>
			<td><input type="text" name="direccion"value="<%=p.getDireccion()!=null?p.getDireccion():""  %>" size="30" maxlength="30" disabled="disabled"/> </td>
		</tr>
		<tr>
			<th>Telefono:</th>
			<td><input type="text" name="telefono" value="<%=p.getTelefono()!=null?p.getTelefono():""  %>" size="9" maxlength="9" disabled="disabled"/> </td>
		</tr>
		<tr>
			<th>Email:</th>
			<td><input type="text" name="email" value="<%=p.getEmail()!=null?p.getEmail():""  %>" size="100" maxlength="100" disabled="disabled"/> </td>
		</tr>
	</table>


<button type="submit" name="Volver" value="Volver">Volver</button>
</form>
</body>
</html>