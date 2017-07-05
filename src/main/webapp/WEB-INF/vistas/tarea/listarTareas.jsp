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

<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <link href="js/bootstrap.min.js" rel="stylesheet" >
	    <link href="js/jquery-1.11.3.min.js" rel="stylesheet" >
	    
	      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

	th, td, h1 {
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
			
			
	<div class="container-fluid">
		<center><h1 align="center">Lista de Tareas</h1></center>
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
					  <th>Proyecto asociado</th>				  
					  <th>Usuario Asignado</th>
					  <th>Estado</th>				  					  
					  <th>Hs Estimadas</th>
					  <th>Horas Reales</th>
					  <th>% Avance</th>					    					  
					  <th>Comentarios</th>		
					  <th>Fecha de Finalizacion</th>					  			    
					  <th>Fecha de Alta</th>
					 </tr>
	     		<thead>
				<tbody>
	 				<c:forEach items="${command}" var="tarea" >					
					  <tr>
					    <td>${tarea.id}</td>
					    <td><a href="editarTarea?id=<c:out value="${tarea.id}"/>"><c:out value="${tarea.descripcion}"/></a></td>						    
					    <td>${tarea.proyecto.descripcion}</td>		
					    <td>${tarea.usuario.email}</td>	
					    <td>
					    	<div>
					    	<!-- Si la tarea está <> "No iniciada" entonces podrá volver atras-->
							<c:choose>
							    <c:when test="${tarea.estado != 'No iniciada'}">
					    			<div><a href="cambiarEstadoAtras?idTarea=<c:out value="${tarea.id}"/>">◄</a></div>
							    </c:when>    
							    <c:otherwise>
					    			<div><p>◄</p></div>
							    </c:otherwise>
							</c:choose>					    	
					    	
					    	<div>${tarea.estado}</div>

					    	<!-- Si la tarea está <> "Finalizada" entonces podrá adelantar-->
							<c:choose>
							    <c:when test="${tarea.estado != 'Finalizada'}">
					    	<div><a href="cambiarEstadoAdelante?idTarea=<c:out value="${tarea.id}"/>">►</a></div>					    	
							    </c:when>    
							    <c:otherwise>
					    			<div><p>►</p></div>
							    </c:otherwise>
							</c:choose>		
					    	</div>
					    </td>
					    <td>${tarea.horasEstimadas}</td>		
					    <td>${tarea.horasReales}</td>	
					    <td>${tarea.porcentajeAvance}</td>				    					    				    					    	
					    <td>${tarea.comentarios}</td>		
					    <td>${tarea.fechaFinalizacion}</td>		
					    <td>${tarea.fechaAlta}</td>		
					  </tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
	</div>
	
			<!-- Footer -->
	        <footer>
	            <div class="row">
	                <div class="col-lg-12 footer">
	                    <center><p>Copyright &copy; Task Manager Pro 2018</p></center>
	                </div>
	            </div>
	        </footer>
</body>
</html>



