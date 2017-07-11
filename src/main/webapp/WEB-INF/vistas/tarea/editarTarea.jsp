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
    h5 { color: white; }
    
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
				<form:form action="editarTarea" method="POST" modelAttribute="tarea" role="form">      
			    	
			    	<h1 class="page-header text-center titulo">Editar Tarea</h1>
			    	
					<form:input type="hidden" path="Id" class="form-control" required="true"/>

					
					<div class="form-group">
	      				<label><h4>Descripción:</h4></label>					
						<form:input path="descripcion" placeholder="Descripcion" class="form-control" required="true"/>					
					</div>

					<div class="form-group">		
	      				<label><h4>Proyecto:</h4></label>
						<form:select path="proyectoId" multiple="false" class="form-control" required="true" disabled="true">
							<form:options items="${proyectos}" itemValue="id" itemLabel="descripcion"/>
						</form:select>					
					</div>

					<div class="form-group">
	      				<label><h4>Usuario asignado:</h4></label>					
						<form:select path="usuarioId" multiple="false" class="form-control" required="true">
							<form:options items="${usuarios}" itemValue="id" itemLabel="email"/>
						</form:select>					
					</div>
							
					<div class="form-group">
						<label><h4>Estado:</h4></label>	
						<label><form:radiobutton path="estado" checked="checked" value="No iniciada"/></label>   
						<label><h5>No iniciada</h5></label>      						   
						<label><form:radiobutton path="estado" value="En curso"/></label>  
						<label><h5> En curso</h5></label>      						   						    
						<label><form:radiobutton path="estado" value="Finalizada"/></label>
						<label><h5>Finalizada</h5></label>      						   											
					</div>	
																							
					<div class="form-group">
	      				<label><h4>Horas estimadas:</h4></label>					
					  	<form:input type="number" path="horasEstimadas" placeholder="Horas estimadas" class="form-control" required="true"/>				
					</div>

					<div class="form-group">
	      				<label><h4>Horas reales:</h4></label>					
					  	<form:input type="number" path="horasReales" placeholder="Horas reales" class="form-control"/>				
					</div>

					<div class="form-group">
	      				<label><h4>% de Avance:</h4></label>					
					  	<form:input type="number" path="porcentajeAvance" placeholder="% de avance" class="form-control"/>				
					</div>											
					
					<div class="form-group">
	      				<label><h4>Comentarios:</h4></label>					
					  	<form:textarea path="comentarios" rows="6" placeholder="Comentarios" class="form-control" maxlength="100"/>				  					
					</div>					
					
					<div class="form-group" align="center">
						<button class="btn btn-lg btn-primary btn-success"  name="Submit" value="Crear Tarea" type="Submit">Guardar</button>
						<a href="/proyecto-limpio-spring/tarea/listarTareas" class="btn btn-lg btn-primary btn-danger" role="button" >Cancelar</a>																								  							
					</div>					

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
		<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Task Manager Pro 2018</p></center>
	                </div> 
	</body>
</html>