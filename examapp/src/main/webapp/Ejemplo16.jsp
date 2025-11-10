<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--  Ejemplo16.jsp -->
<%-- Este no se ve en el cliente --%>

<%! int numero = 0; %>

<%! public String fecha(){

		return (new java.util.Date()).toString();

	}%>



<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

<h1>TABLA CONTADOR: </h1>

<table>

	<% 

	for (int i = numero; i <numero+10; i++) { 

	%>

	<tr>

		<td> Numero </td>

		<td> <%=i %></td>

	</tr>

	<% 

	}

	%>

	<%numero+=10; %>

</table>

<p>La fecha actual es: <%=fecha() %></p>

</body>

</html>

