<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletAlumnos" method="post">
		<Table align="center" border="2">
			<tr>
				<td>GESTIÓN ALUMNOS</td>
			</tr>
			<tr>
				<td>
					<p align="left">Nombre:</p> <input type="text" name="nombre" required/>
					<p align="left">Apellidos:</p> <input type="text" name="apellidos" required/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Consultar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>