<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet" >
 <link href="../css/bootstrap.min.css" rel="stylesheet" >
 
<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../css/estilos.css" rel="stylesheet">

<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">

<style>

	th, td {
	    color: white;
	}

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
			
			
	<div class="container-fluid">
		<center><h1 align="center">Lista de tareas</h1></center>
	</div>
	
	<div>
		<br></br>			
		<center><a href="altaTarea" class="btn btn-danger btn-lg active" role="button">Crear Tarea</a></center>				
	</div>
	<br>
	<br>		
	<div class="container">			
		<div class="table-responsive">          
			<table class="table">
				<thead>
					 <tr>
					  <th>ID</th>
					  <th>Descripcion</th>
					  <th>Usuario Asignado</th>
					  <th>Estado</th>
					  <th>% Avance</th>					    
					  <th>Hs Estimadas</th>
					  <th>Horas Reales</th>
					  <th>Comentarios</th>					    
					  <th>Proyecto asociado</th>
					  <th>Fecha de Alta </th>
					 </tr>
	     		<thead>
				<tbody>
	 				<c:forEach items="${command}" var="tarea" >					
					  <tr>
					    <td>${tarea.id}</td>
					    <td><a href="editarTarea?id=<c:out value="${tarea.id}"/>"><c:out value="${tarea.descripcion}"/></a></td>						    
					    <!--<td>${tarea.descripcion}</td> -->
					    <td>${tarea.usuarioAsignado}</td>
					    <td>${tarea.estado}</td>
					    <td>${tarea.porcentajeAvance}</td>	
					    <td>${tarea.horasEstimadas}</td>		
					    <td>${tarea.horasReales}</td>		
					    <td>${tarea.comentarios}</td>		
					    <td>${tarea.descripcionProyecto}</td>		
					    <td>${tarea.fechaAlta}</td>		
					  </tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
	</div>
</body>
</html>



