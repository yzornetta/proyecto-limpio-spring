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
		

				<div class="container">
	       		 	<div class="row">
	           		 	<div class="col-xs-12">

		            <h1 class="text-center texto-login">MODIFICAR PASSWORD</h1>	           
	           
					<div class="col-xs-6 col-xs-offset-3 transparencia contenedor-registracion">
						<form:form method="POST" action="modificarPassword" modelAttribute="classRegistrarse" class="form-horizontal" role="form">
							
							<div class="form-group">
						    	<h4 for="nombre_password">Password Actual:</h4>
								<form:input path="" type="password" id="nombre_password" class="form-control" required="required"/>
							</div>							
						    <div class="form-group">
						    	<h4 for="nueva_password">Password nueva:</h4>
								<form:input path="password" type="password" id="password" class="form-control" required="required"/>
						    </div>						        
						    <div class="form-group">
						    	<h4 for="repetir_password">Repetir Password:</h4>
						    	<form:input path="" type="password" class="form-control" id="confirmar_password" required="required"/>
						    </div>
						    
						    <div class="form-group">	
						    <form:input path="" type="hidden" class="form-control" id="confirmar_password_actual" value="${password}" required="required"/>				        				  
						  	</div>
						  	
						  	<div class="form-group">	
						    <form:input path="id" type="hidden" class="form-control" id="id_user" value="${Id}" required="required"/>				        				  
						  	</div>
						  	<div class="form-group">
						   
								<form:input path="nombre" type="hidden" id="nombre_usr" class="form-control" value="${nombre}" required="required"/>
							</div>							
						    <div class="form-group">
						    	
								<form:input path="apellido" type="hidden" id="apellido_usr" class="form-control" value="${apellido}" required="required"/>
						    </div>						        
						    <div class="form-group">
						    	
						    	<form:input path="email" type="hidden" class="form-control" id="mail_usr" value="${email}" required="required"/>
						    </div>
						  	  
						  	  <div>
								<center><button type="submit" class="btn btn-success btnRegistrarse">MODIFICAR</button></center>
							</div>												
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



<script type="text/javascript">

var password = document.getElementById("password")
var confirm_password = document.getElementById("confirmar_password");

function validatePassword(){
	
		if(password.value != confirm_password.value) {
  			confirm_password.setCustomValidity("Las password no son iguales");
		} else {
  		confirm_password.setCustomValidity('');
		}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

</script>

<script type="text/javascript">

var nombre_password = document.getElementById("nombre_password")
var confirmar_password_actual = document.getElementById("confirmar_password_actual");

function validatePasswordServidor(){
	
		if(nombre_password.value != confirmar_password_actual.value) {
			nombre_password.setCustomValidity("Las password actual no es valida");
		} else {
			nombre_password.setCustomValidity('');
		}
}

nombre_password.onchange = validatePasswordServidor;
confirmar_password_actual.onkeyup = validatePasswordServidor;


</script>


