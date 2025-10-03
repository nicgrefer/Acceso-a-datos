<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 5</title>
</head>
<body>
	<form action=""  method="">
		<fieldset>
			<legend>Datos matricula</legend>
			<p>
				Asignatura/s: <select name="asignatura" size="4">
					<option value="matematicas">Matemáticas</option>
					<option value="literatura">Literatura</option>
					<option value="ingles">Inglés</option>
					<option value="tecnologia">Tecnología</option>
				</select>
			</p>

			<p>
				Sexo: <input type="radio" id="hombre" name="sexo" value="hombre"
					checked> <label for="hombre">Hombre</label> <input
					type="radio" id="mujer" name="sexo" value="mujer"> <label
					for="mujer">Mujer</label>
			</p>

			<p>
				Actividades extraescolares: <input type="checkbox" id="musica"
					name="actividades" value="musica"> <label for="musica">Música</label>

				<input type="checkbox" id="futbol" name="actividades" value="futbol">
				<label for="futbol">Fútbol</label> <input type="checkbox"
					id="teatro" name="actividades" value="teatro"> <label
					for="teatro">Teatro</label>
			</p>

			<p>
				<button type="submit">Enviar</button>
			</p>
		</fieldset>
	</form>
</body>
</html>