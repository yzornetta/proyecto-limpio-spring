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
	<br></br> 
	
	<div class="container-fluid">
		<center><h1 align="center">Lista de Usuarios</h1></center>
	</div>

	<div class="container">			
		<div class="table-responsive">          
			<table class="table">
				<thead>
					 <tr>
					    <th>ID</th>
					    <th>Email</th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Password</th>
					 </tr>
	     		<thead>
				<tbody>
	 				<c:forEach items="${command}" var="usuario" >					
					  <tr>
						    <td>${usuario.id}</td>
						    <td>${usuario.email}</td>
						    <td>${usuario.nombre}</td>
						    <td>${usuario.apellido}</td>	
					  </tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
	</div>	

	<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Task Manager Pro 2018</p></center>
	                </div> 					
</body>
</html>



