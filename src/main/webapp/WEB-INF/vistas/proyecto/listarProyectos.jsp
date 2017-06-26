<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
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
							<li><a class="btn btn-menu" href="/proyecto-limpio-spring/exit"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
						  	<li><a class="btn btn-menu" href="/proyecto-limpio-spring/home">${email}</a></li>
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


	
	 <div class="container">
	       	<div class="row">
	           		 <div class="col-xs-12">
	           		 	
				 <h2 class="text-center texto-login">Lista de Proyectos</h2>
				
			<div class="col-xs-6 col-xs-offset-3 transparencia contenedor-registracion">
				<div class="form-group">							
				<form>				
					<table>					
					  <tr>
					    <th>ID</th>
					    <th>Descripcion</th>
					    <th>Hs Estimadas</th>
					    <th>Horas Reales</th>
					    <th>% Avance</th>
					    <th>Fecha Finalizacion</th>
						<th>Fecha Alta </th>
					  </tr>
		  				<c:forEach items="${command}" var="proyecto" >					
						  <tr>
						    <td>${proyecto.id}</td>
						    <td><a href="listarProyecto?id=<c:out value="${proyecto.id}"/>"><c:out value="${proyecto.descripcion}"/></a></td>
						    <td>${proyecto.horasEstimadas}</td>
						    <td>${proyecto.horasReales}</td>
						    <td>${proyecto.porcentajeAvance}</td>
						    <td>${proyecto.fechaFinalizacion}</td>	
						    <td>${proyecto.fechaAlta}</td>		
						  </tr>
						</c:forEach>			
					</table>
					<br>
					<br>
					<div>
					<center><a href="altaProyecto" class="btn btn-danger btn-lg active" role="button">Crear proyecto</a></center>
					</div>
				</form>
				</div>
			</div>>	
			</div>						 
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