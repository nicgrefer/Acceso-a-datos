<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<%
	Integer accesos = (Integer) session.getAttribute("acceso");
	if  (accesos == null){
		accesos = 0;
	}
	
	accesos = accesos.intValue()+1;
	session.setAttribute("acceso", accesos);
	
	if (request.getParameter("Invalidasession")!= null){
		session.invalidate();
	}
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Sessiones</title>
</head>
<body>

<form>

	<input type="submit" name="Invalidasession" value="Invalida Sesion">
	<input type="submit" value="Recarga Sesion">

</form>

<br> Contador:
<%= accesos.intValue() %>

</body>
</html>