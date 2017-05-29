<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="altaProyecto"">
				<form:form action="guardar-proyecto" method="POST" modelAttribute="proyecto">      
			    	<h3 class="form-signin-heading">ALTA DE PROYECTOS</h3>
					<hr class="colorgraph"><br>
			        <h4><span>Ingrese descripción</span></h4>
					<form:input path="descripcion" id="descripcion" type="text" class="form-control"></form:input>
					<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Proyecto" type="Submit">Guardar</button>  			
				</form:form>
				<c:if test="${not empty descripcion}">
			        <h4><span>${descripcion}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
