<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="model.Votacion" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    h1 {
        text-align: center;
    }
</style>
</head>
<body>
<h1>Resultados de la Votación</h1>

<%
    HashMap<String, Votacion> mapVotos = (HashMap<String, Votacion>) application.getAttribute("mapVotos");
    
    if (mapVotos != null && !mapVotos.isEmpty()) {
%>
<table>
    <tr>
        <th>Candidato</th>
        <th>Número de Votos</th>
    </tr>
    <%
        for (Votacion v : mapVotos.values()) {
    %>
    <tr>
        <td><%= v.getAlumnos() %></td>
        <td><%= v.getNumVotos() %></td>
    </tr>
    <%
        }
    %>
</table>
<%
    } else {
%>
<p style="text-align: center;">No hay votos registrados todavía.</p>
<%
    }
%>

<br>
<div style="text-align: center;">
    <a href="Votacion.jsp"><button>Volver a votar</button></a>
</div>

</body>
</html>