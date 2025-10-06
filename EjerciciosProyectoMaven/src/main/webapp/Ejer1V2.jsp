<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejer1 V2</title>
</head>
<body>
    <form action="ServletEjer1V2" method="get" >
        <fieldset>
            <legend>Saludo</legend>
            
            <table>
                <tr>
                    <td>Mensaje:</td>
                    <td><input type="text" name="mensaje"></td>
                </tr>
                <tr>
                    <td>Firma:</td>
                    <td><input type="text" name="firma"></td>
                </tr>
            </table>
            
            <br>
            <input type="submit" value="Enviar">
            <input type="reset" value="Borrar">
        </fieldset>
    </form>
</body>
</html>
