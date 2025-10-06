<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de datos</title>
</head>
<body>
    <form action="ServletEjer3" method="post">
        <fieldset>
            <legend>Recogida de datos</legend>

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" size="25"><br><br>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" size="35"><br><br>

            <label for="direccion">Dirección:</label><br>
            <textarea id="direccion" name="direccion" rows="4" cols="40"></textarea><br><br>

            <label>Tipo de tarjeta:</label><br>
            <input type="radio" id="visa" name="tipTarjeta" value="visa" required>
            <label for="visa">Visa</label><br>
            
            <input type="radio" id="mastercard" name="tipTarjeta" value="mastercard">
            <label for="mastercard">MasterCard</label><br>
            
            <input type="radio" id="amex" name="tipTarjeta" value="amex">
            <label for="amex">American Express</label><br><br>

            <label for="nTarjeta">Número de tarjeta:</label>
            <input type="text" id="nTarjeta" name="nTarjeta" size="25" maxlength="16"><br><br>

        </fieldset>
        <br>
        <input type="submit" value="Enviar">
        <input type="reset" value="Borrar">
    </form>
</body>
</html>