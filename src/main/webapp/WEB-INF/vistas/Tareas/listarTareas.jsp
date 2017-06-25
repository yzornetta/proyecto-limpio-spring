<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	
	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" href="../../favicon.ico">
	    
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    
	    <style>
    h4 { color: white; }
    h1 { color: white; }
  		</style>
	    
	</head>

<body>

		<nav class="navbar navbar-fixed-top menu">
  			<div class="container-fluid">
				<ul class="nav nav-pills navbar-right">
				  	<c:choose>
					  	<c:when test="${email != null}">
					  		<li><a class="btn btn-menu" href="/proyecto-limpio-spring/exit"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
						  	<li><a class="btn btn-menu" href="/proyecto-limpio-spring/home">${email}</a></li>
					  	</c:when>
					  	<c:otherwise>
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring/nuevoUsuario"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
						  	<li><a class="btn btn-menu" href="./login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>							  	
				</ul>
			</div>
		</nav>	
	
	<br></br> 
	<div class="container-fluid">
		<div class="panel panel-info"> 
			<div>
				<br></br>			
				<a href="altaTarea" class="btn btn-danger btn-lg active" role="button">Crear Nueva Tarea</a>				
			</div>
			<div>
				<h3 align="left">Tareas</h1>
			</div>
			<div class="panel-body">   								
				<form>
					<table>
					  <tr>
					    <th>ID</th>
					    <th>Nombre de Tarea</th>
					    <th>Estado</th>
					    <th>Usuario</th>
					    <th>Comentarios</th>
					    </tr>
		  				<c:forEach items="${command}" var="Tarea" >					
						  <tr>
						    <td>${Tarea.id}</td>
						    <td><a href="listarTareas?id=<c:out value="${tarea.id}"/>"><c:out value="${tarea.descripcion}"/></a></td>
						    <td>${Tarea.nombreTarea}</td>
						    <td>${Tarea.estado}</td>
						    <td>${Tarea.usuario}</td>
						    <td>${proyecto.comentarios}</td>							    		
						  </tr>
						</c:forEach>			
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>