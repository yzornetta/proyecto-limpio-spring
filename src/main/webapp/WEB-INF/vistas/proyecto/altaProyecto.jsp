<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Proyecto</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet" >
<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
<div class="panel panel-primary"> 
<div class="panel-heading">
<h1 class="center-block"><center>Administrador de Proyectos</center></h1>
</div>
</div>
</div>
<br><br>

<div class="container-fluid">
<div class="panel panel-info"> 
<div class="panel-body">
<form:form action="agregarProyecto.html" method="GET" >
<div class="row">
  <div class="col-xs-3">
	<form:input path="descripcion" placeholder="Nombre del proyecto" class="form-control input-sm"/>
	</div>
	</div>
	<br>
	<input type="submit" value="Crear Proyecto" class="btn btn-primary btn-lg" />
</form:form>
</div>
</div>
</div>
</body>
</html>