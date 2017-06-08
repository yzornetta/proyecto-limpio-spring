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
					  		<li><a class="btn btn-menu" href="proyecto-limpio-spring/0"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
						  	<li><a class="btn btn-menu" href="#">${email}</a></li>
					  	</c:when>
					  	<c:otherwise>
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring/nuevoUsuario"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
						  	<li><a class="btn btn-menu" href="./login=0"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>							  	
				</ul>
			</div>
		</nav>	
		

				<div class="container">
	       		 	<div class="row">
	           		 	<div class="col-xs-12">

		            <h1 class="text-center texto-login">Registración</h1>	           
	           
					<div class="col-xs-6 col-xs-offset-3 transparencia contenedor-registracion">
						<form:form method="POST" action="registracion" modelAttribute="classRegistrarse" class="form-horizontal" role="form">
							
							<div class="form-group">
						    	<h4 for="nombre_usr">Nombre:</h4>
								<form:input path="nombre" type="text" id="nombre_usr" class="form-control" required="required"/>
							</div>							
						    <div class="form-group">
						    	<h4 for="apellido_usr">Apellido:</h4>
								<form:input path="apellido" type="text" id="apellido_usr" class="form-control" required="required"/>
						    </div>						        
						    <div class="form-group">
						    	<h4 for="mail_usr">Email:</h4>
						    	<form:input path="email" type="text" class="form-control" id="mail_usr" required="required"/>
						    </div>						        
						    <div class="form-group">
						    	<h4 for="pwd">Contraseña:</h4>
						    	<form:input path="password" type="password" class="form-control" id="pwd" required="required"/>
						  	</div>						  	
						  	<div class="form-group">
						    	<h4 for="pwd">Repetir Contraseña:</h4>
						    	<form:input path="passwordConf" type="password" class="form-control" id="pwd" required="required"/>
						  	</div>
						  	<div>
								<center><button type="submit" class="btn btn-success btnRegistrarse">Registrarse</button></center>
							</div>
							<br>						
							<div>
								<center><a class="btn btn-danger btnCancelar" href="/proyecto-base-spring">Cancelar</a></center>
							</div>
							
						</form:form>
				    </div>	
				   </div>
				  </div>
				</div>		
			
			<hr>
       		<!-- Footer -->
	        <footer>
	            <div class="row">
	                <div class="col-lg-12 footer">
	                    <center><p>Copyright &copy; Task Manager Pro 2018</p></center>
	                </div>
	            </div>
	        </footer>
		</div>
	</body>
</html>


