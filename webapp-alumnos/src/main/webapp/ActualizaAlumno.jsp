<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><title>Insert title here</title></head><body>
	<form action="ServletAlumnos" method="post">
		<table align="center" border="2">
			<tr>
				<td colspan="3">GESTIÓN ALUMNOS</td>
			</tr>
		<tr >
				<td colspan="4">
					<p align="left">Nombre:</p> <input type="text" name="nombre"  required />
					<p align="left">Apellidos:</p> <input type="text" name="apellidos" required/>
					<p align="left">Ciclo:</p> <input type="text" name="ciclo"  />
					<p align="left">Curso:</p> <input type="text" name="curso" />
				</td>
			<tr>			<tr>
				<td><input type="submit" name="boton" value="Actualizar" /></td>				<td><input type=submit name=volver value=Volver></td>
			</tr>
		</table>
	</form>
</body>
</html>