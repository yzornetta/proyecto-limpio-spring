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
</head>

<body>
	<div class="container-fluid">
	    <div class="panel panel-primary"> 
		  	<div class="panel-heading">
		    	<h1 class="center-block"><center>Administrador de Proyectos</center></h1>
			</div>
		</div>
	</div>
	<br></br> 
	<div class="container-fluid">
		<div class="panel panel-info"> 
			<div>
				<br></br>			
				<a href="altaProyecto" class="btn btn-danger btn-lg active" role="button">Crear proyecto</a>				
			</div>
			<div>
				<h3 align="left">Lista de Proyectos</h1>
			</div>
			<div class="panel-body">   
				<c:forEach items="${command}" var="proyecto" >
					<c:if test="${not empty proyecto.descripcion}">
						<div>
							<div></div>
							<a href="listarProyecto" path="descripcion" name="descripcion" class="btn btn-primary btn-lg">${proyecto.descripcion} </a>
							<div></div>
						</div>
		        	</c:if>	
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>



