<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salúdame</title>
</head>
<body>
    <form action="ServletEjer1" method="get">
        <label for="idioma">Elige idioma (es/in/fr):</label>
        <input type="text" id="idioma" name="idioma">
        <input type="submit" value="Salúdame">
    </form>
    
    <form action="ServletEjer1" method="post">
        <h3>Selecciona un idioma:</h3>

        <input type="radio" id="es" name="idioma" value="es" required>
        <label for="es">Español</label><br>

        <input type="radio" id="en" name="idioma" value="en">
        <label for="en">Inglés</label><br>

        <input type="radio" id="it" name="idioma" value="it">
        <label for="it">Italiano</label><br>

        <input type="radio" id="fr" name="idioma" value="fr">
        <label for="fr">Francés</label><br><br>

        <input type="submit" value="Saludar">
    </form>
    
</body>
</html>
