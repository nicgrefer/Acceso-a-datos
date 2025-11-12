<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

out.println(request.getParameter("arg1"));
out.println(request.getParameter("arg2"));
out.println(request.getParameter("arg3"));

%>

</body>
</html>