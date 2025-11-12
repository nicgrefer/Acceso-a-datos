<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<td><input type="text" name="dni" size="9" maxlength="9" required="required"/> </td>
		</tr>
		<tr>
			<th>Nombre:</th>
			<td><input type="text" name="nombre" size="20" maxlength="20" required="required"/> </td>
		</tr>
		<tr>
			<th>Apellidos:</th>
			<td><input type="text" name="apellido" size="20" maxlength="20" required="required"/> </td>
		</tr>
		<tr>
			<th>Direccion:</th>
			<td><input type="text" name="direccion" size="30" maxlength="30" required="required"/> </td>
		</tr>
		<tr>
			<th>Telefono:</th>
			<td><input type="text" name="telefono" size="9" maxlength="9" required="required"/> </td>
		</tr>
		<tr>
			<th>Email:</th>
			<td><input type="text" name="email" size="100" maxlength="100" required="required"/> </td>
		</tr>
	</table>

<button type="submit" name="Enviar" value="Enviar">Enviar</button>

</form>
</body>
</html>