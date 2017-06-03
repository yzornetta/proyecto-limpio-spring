<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Alata usuario</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	ALTA DE USUARIO
</h1>

<c:url var="altaAction" value="/alta" ></c:url>

<form:form action="${altaAction}" commandName="altaUsuario">
<table>
	<c:if test="${!empty altaUsuario.email}">
	</c:if>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	
	<tr>
		<td colspan="1">
			<c:if test="${empty altaUsuario.email}">
				<input type="submit"
					value="<spring:message text="Alta de usuario"/>" />
			</c:if>
		</td>
	</tr>
	
</table>	
</form:form>
<br>

</body>
</html>