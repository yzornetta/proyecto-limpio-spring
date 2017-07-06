<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    
	<!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="../css/estilos.css" rel="stylesheet">
	    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <link href="js/bootstrap.min.js" rel="stylesheet" >
	    <link href="js/jquery-1.11.3.min.js" rel="stylesheet" >
	    
	      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	    
	     <style>
    h4 { color: white; }
    h1 { color: white; }
    h2 { color: white; }
    h5 { color: white; }
    
  		</style>
	    
	</head>
	<body>
	
	<!-- 
	<nav class="navbar navbar-fixed-top menu">
  			<div class="container-fluid">
				<ul class="nav nav-pills navbar-right">
				  	<c:choose>
					  	<c:when test="${email != null}">
				  			<li><a class="btn btn-menu" href="/proyecto-limpio-spring/home"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
	 						<li class="dropdown">
          						<a class="dropdown-toggle" data-toggle="dropdown" href="/proyecto-limpio-spring/home">${email}<span class="caret"></span></a>
          							<ul class="dropdown-menu">
            							<li><a href="/proyecto-limpio-spring/modificarUsuario">Perfil</a></li>
            							<li><a href="/proyecto-limpio-spring/modificarPassword">Modificar Password</a></li>
            							<li role="separator" class="divider"></li>
            							<li><a href="/proyecto-limpio-spring/exit">Cerrar Sesion</a></li>
          							</ul>
        					</li>
					  	</c:when>
					  	<c:otherwise>
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring/nuevoUsuario"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
						</c:otherwise>
					</c:choose>							  	
				</ul>
			</div>
		</nav>	
	 -->	
		<div class = "container">
				<form:form action="asignarUsuarios" method="POST" modelAttribute="usuarioProyecto" role="form">      
			    	
			    	<!--<h2 class="page-header text-center titulo">Asignar Usuario</h1>-->
			    	
					<div class="form-group">		
	      				<label><h4>Proyecto:</h4></label>
						<form:select path="proyectoId" multiple="false" class="form-control" required="true">
							<!--<form:options items="${proyectos}" itemValue="id" itemLabel="descripcion"/>-->
							  <option value="${ProyectoSeleccionado.id}">${ProyectoSeleccionado.descripcion}</option>							
						</form:select>					
					</div>

					<div class="form-group">
	      				<label><h4>Usuario:</h4></label>					
						<form:select path="usuarioId" multiple="false" class="form-control" required="true">
							<form:options items="${usuarios}" itemValue="id" itemLabel="email"/>
						</form:select>					
					</div>
																																	
					<div class="form-group">
						<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Crear Tarea" type="Submit">Asignar</button>  							
					</div>					
			        <h4><span>${error}</span></h4>

				</form:form>
				
			
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		</div>


		<div class="container">	
	    	<h4>Lista de usuarios asignados:</h4>		
			        <h4><span>${error}</span></h4>
			<div class="table-responsive">  
				       
				<table class="table">
					<thead>
						 <tr>
						    <th></th>					 
						    <th><h5>Email</h5></th>
						 </tr>
		     		<thead>
					<tbody>
		 				<c:forEach items="${listaUsuariosProyecto}" var="usuarioProyecto" >	
						  <tr>
						    <td><a href="eliminarUsuarioProyecto?idUsuario=<c:out value="${usuarioProyecto.usuario.email}"/>" data-toggle="tooltip" title="Quitar usuario"><c:out value=""/><span class="glyphicon glyphicon-remove"></span></a></td>						    						    
						    <td><h5>${usuarioProyecto.usuario.email}</h5></td>
						  </tr>
						</c:forEach>
					</tbody>			
				</table>
			</div>
		</div>	
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>