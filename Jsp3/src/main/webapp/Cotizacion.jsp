<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="entities.Cotizacion,java.util.*,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String fechaActual=(String)application.getAttribute("fechaActual");
String deshabilitar = application.getAttribute("acceso_"+fechaActual) != null
		&& (Integer) application.getAttribute("acceso_"+fechaActual) >0 ? "disabled" : "";
%>
<body>
	<form action="ServletCotizacion" method="post">
		<h1>COTIZAGF S.L.</h1>
		<h2>
			La sesión está activa por el usuario:<%=session.getAttribute("user")%></h2>
		<h2>
			Fecha nueva cotización:<%=fechaActual%></h2>
					<table border="1">
			<tr>
				<td>Ciclo</td>
				<td>Valor Actual</td>
				<td>Valor Nuevo</td>
			</tr>
			<%
			HashMap<String, Cotizacion> cotizaciones = (HashMap<String, Cotizacion>) application.getAttribute("listCotiza");
				for (String key : cotizaciones.keySet()) {
			%>
			<tr>
				<td><%=key%></td>
				<td><%=cotizaciones.get(key).getAnterior()%></td>
				<td><input type="number" name="<%=key%>" value="" size="4"
					<%=deshabilitar%> maxlength="4"></td>
			</tr>

			<%
			}
			%>
		</table>
		<br>
		<%
		if (deshabilitar.equals("disabled")) {
		%>
		<p>La bolsa de cotización GF está cerrada en el día de hoy con los
			valores indicados en la tabla hasta nueva actualización.</p>
		<%
		}
		%>
		<input type="submit" name="boton" value="Enviar"
			<%=deshabilitar%>>
	</form>
</body>
</html>