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
		<div class = "container">
			<div id="altaProyecto"">
				<form:form action="guardar-tarea" method="POST" modelAttribute="Tarea">      
			    	<h3 class="form-signin-heading">ALTA DE TAREAS</h3>
					<hr class="colorgraph"><br>
			       	<h4><span>Ingrese la Tarea</span></h4>
					<form:input path="comentarios" id="comentarios" type="text" class="form-control"></form:input>
					<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Crear Tarea" type="Submit">Guardar</button>  			
				</form:form>
				<c:if test="${not empty comentarios}">
			        <h4><span>${comentarios}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>tml>