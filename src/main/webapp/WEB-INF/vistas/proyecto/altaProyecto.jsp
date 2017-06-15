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
						  	<li><a class="btn btn-menu" href="http://localhost:8080/proyecto-limpio-spring/nuevoUsuario"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>							  	
				</ul>
			</div>
		</nav>	
		
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">		
				<form:form action="agregarProyecto" method="POST" modelAttribute="classAltaProyecto" role="form">      
			    	<h1 class="page-header text-center titulo">Alta de Proyectos</h1>
					<br>					
					<form:input path="descripcion" placeholder="Nombre del proyecto" class="form-control"/>
					<br>
				  	<form:input path="horasEstimadas" placeholder="Horas estimadas" class="form-control"/>
				  	<br>
				  	<form:input path="horasReales" placeholder="Horas reales" class="form-control"/>
					<br>
				  	<form:input path="porcentajeAvance" placeholder="% de avance" class="form-control"/>
					<br>
				  	<form:input path="fechaFinalizacion" placeholder="Fecha de Finalizacion" class="form-control"/>				  	
				  	<br>
				  	<br>		
					<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Crear Proyecto" type="Submit">Guardar</button>  			
				</form:form>
				
				
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>						
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<br>		
		<br>	
		<br>		
		<br>
		<br>		
		<br>
		<br>		
		<br>
		<br>		
		<br>
		<br>		
		<br>	
		<br>
		<br>		
		<br>
		<br>
		<hr>
		
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