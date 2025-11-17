<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%String user=session.getAttribute("user")!=null?(String)session.getAttribute("user"):"";%>
<body>
<form action="ServletCotizacion" method="post">
<fieldset>
		<legend><h1>COTIZAGF S.L.</h1></legend>
		<table>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text" name="nombre" value="${user}" ></td>

			</tr>
			<tr>
				<td><label>Código pin:</label></td>
				<td><input type="password" name="password"  ></td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Acceso"></td>
				<td><input type="submit" name="boton" value="Cerrar"></td>

			</tr>
		</table>
		<%if (request.getAttribute("mensaje")!=null && !request.getAttribute("mensaje").equals("")) {%>
		  <p style="color:red;">${mensaje}</p>
		<%} %>
		</fieldset>
	</form>
</body>
</html>