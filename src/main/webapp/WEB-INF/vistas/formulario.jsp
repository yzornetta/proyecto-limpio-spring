<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Proyecto</title>
</head>
<body>
<form:form action="agregar.html" method="GET" >
	<form:label path="nombre">Nombre proyecto</form:label>
	<form:input path="nombre"/>
	
	<input type="submit" value="Crear"/>

</form:form>
</body>
</html>