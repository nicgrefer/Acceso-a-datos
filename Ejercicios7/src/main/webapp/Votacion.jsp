<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Elección de delegado</h1>

<form action="ServetVotaciones" method="post">
<p>Los delegados que se presentan a miembros del Consejo Escolar son...</p>

<input type="checkbox" name="alumno" value="ruth_fernandez">
    RUTH FERNANDEZ

<br>    

<input type="checkbox" name="alumno" value="victor_vergel">
    VICTOR VERGEL

<br>
<button type="submit" name="enviar" value="enviar">Enviar</button>

</form>
</body>
</html>