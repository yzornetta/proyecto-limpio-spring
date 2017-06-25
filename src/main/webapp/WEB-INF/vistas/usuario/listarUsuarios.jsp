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
<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
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

	<!-- <div class="container-fluid">
	    <div class="panel panel-primary"> 
		  	<div class="panel-heading">
		    	<h1 class="center-block"><center>Administrador de Proyectos</center></h1>
			</div>
		</div>
	</div>  -->
	<br></br> 
	<div class="container-fluid">
		<div class="panel panel-info"> 
			<div>
				<h3 align="left">Lista de Usuarios</h1>
			</div>
			<div class="panel-body">   								
				<form>
					<table>
					  <tr>
					    <th>ID</th>
					    <th>Email</th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Password</th>
					  </tr>
		  				<c:forEach items="${command}" var="usuario" >					
						  <tr>
						    <td>${usuario.id}</td>
						    <td>${usuario.email}</td>
						    <td>${usuario.nombre}</td>
						    <td>${usuario.apellido}</td>	
						    <td>${usuario.password}</td>							    
						  </tr>
						</c:forEach>			
					</table>
				</form>
			</div>
			<div>
				<a href="../home" class="btn btn-lg btn-primary">Volver al Home</a>	
			</div>			
		</div>
	</div>
</body>
</html>


