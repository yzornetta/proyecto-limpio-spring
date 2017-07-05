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
		
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">		
				<form:form action="editarProyecto" method="POST" modelAttribute="proyecto" role="form">      
			    	<h1 class="page-header text-center titulo">Alta de Proyectos</h1>
					
					<form:input type="hidden" path="Id" class="form-control" required="true"/>
					
					<div class="form-group">
	      				<label><h4>Descripción:</h4></label>					
						<form:input path="descripcion" placeholder="Nombre del proyecto" class="form-control"/>
					</div>
					
					<div class="form-group">
	      				<label><h4>Horas estimadas:</h4></label>					
				  		<form:input path="horasEstimadas" placeholder="Horas estimadas" class="form-control"/>
					</div>

					<div class="form-group">
	      				<label><h4>Horas reales:</h4></label>					
				  		<form:input path="horasReales" placeholder="Horas reales" class="form-control"/>
					</div>
					
					<div class="form-group">
	      				<label><h4>Fecha de finalizacion:</h4></label>					
						<label><form:input type="date" path="fechaFinalizacion" placeholder="Fecha finalizacion" class="form-control"/></label>
					</div>

					<div class="form-group">
	      				<label><h4>Comentarios:</h4></label>					
					  	<form:textarea path="comentarios" rows="6" placeholder="Comentarios" class="form-control"/>				  					
					</div>	

					<div class="form-group">
						<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Crear Proyecto" type="Submit">Guardar</button>  			
					</div>

				  	<!-- 
				  	Lista de usuarios
					<c:forEach items="${command}" var="usuario" >											  	
						<div class="checkbox">
							<label><input type="checkbox" value="${usuario.id}" >${usuario.email}</label>
						</div>
					</c:forEach>
					 -->
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