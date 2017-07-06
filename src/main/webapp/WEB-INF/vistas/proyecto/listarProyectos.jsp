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
 <link href="../css/bootstrap.min.css" rel="stylesheet" >
 
<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../css/estilos.css" rel="stylesheet">

<!-- Bootstrap theme -->
<link href="../css/bootstrap-theme.min.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <link href="js/bootstrap.min.js" rel="stylesheet" >
	    <link href="js/jquery-1.11.3.min.js" rel="stylesheet" >
	    
	      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>

    function pop1(id){
    	
    		var w = 395;
    		var h = 415;
    	    var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
    	    var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;

    	    var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
    	    var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

    	    var left = ((width / 2) - (w / 2)) + dualScreenLeft;
    	    var top = ((height / 2) - (h / 2)) + dualScreenTop;
    	    var newWindow = window.open('asignarUsuarios?idProyecto=' + id, 'Asignación de usuarios', 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

    	    // Puts focus on the newWindow
    	    if (window.focus) {
    	        newWindow.focus();
    	    }
    	
        //window.open('asignarUsuarios?idProyecto=' + id,'popwin','width=395, height=415, top=top');

    }

    </script>

<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

<style>

	th, td, h1 {
	    color: white;
	}

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

	<div class="container-fluid">
		<center><h1 align="center">Lista de Proyectos</h1></center>
	</div>
	
	<div>
		<br></br>			
		<center><a href="altaProyecto" class="btn btn-danger btn-lg active" role="button">Crear Proyecto</a></center>				
	</div>
	<br>
	<br>		
	<div class="container">			
		<div class="table-responsive">          
			<table class="table">
				<thead>
					 <tr>
					    <th>ID</th>
					    <th></th>
					    <th></th>					    					    					    
					    <th>Descripcion</th>
					    <th>Hs Estimadas</th>
					    <th>Horas Reales</th>
					    <th>% Avance</th>
					    <th>Fecha Finalizacion</th>
						<th>Comentarios</th>					    
						<th>Fecha de Alta </th>
					 </tr>
	     		<thead>
				<tbody>
	 				<c:forEach items="${command}" var="proyecto" >					
					  <tr>
						    <td>${proyecto.id}</td>
						    <td><a href="editarProyecto?id=<c:out value="${proyecto.id}"/>" data-toggle="tooltip" title="Editar proyecto"><c:out value=""/><span class="glyphicon glyphicon-pencil"></span></a></td>						    						    
						    
						    <td><a data-toggle="tooltip" title="Asignar usuarios al proyecto" href="#" onclick="pop1(${proyecto.id})"><span class="glyphicon glyphicon-user"></span></a></td>						    						    						 
						    
						    <!-- <td><a href="asignarUsuarios?idProyecto=<c:out value="${proyecto.id}"/>"  data-toggle="tooltip" title="Asignar usuarios al proyecto"><c:out value=""/><span class="glyphicon glyphicon-user"></span></a></td> -->						    						    						 
						    
						    <!--<td><a href="listarProyecto?id=<c:out value="${proyecto.id}"/>"><c:out value="${proyecto.descripcion}"/></a></td> -->
						    <td><a data-toggle="tooltip" title="Ir a tareas del proyecto" href="../tarea/listarTareasPorProyecto?idProyecto=<c:out value="${proyecto.id}"/>"><c:out value="${proyecto.descripcion}"/></a></td>						    
						    <td>${proyecto.horasEstimadas}</td>
						    <td>${proyecto.horasReales}</td>
						    <td>${proyecto.porcentajeAvance}</td>
						    <td>${proyecto.fechaFinalizacion}</td>	
							<td>${proyecto.comentarios}</td>		    						   
						    <td>${proyecto.fechaAlta}</td>		
					  </tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
	</div>
	
			
       		<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Task Manager Pro 2018</p></center>
	                </div> 
</body>
</html>



