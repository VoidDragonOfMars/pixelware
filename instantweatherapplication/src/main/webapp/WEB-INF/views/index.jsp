<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather App</title>
<link rel="stylesheet" href="resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="resources/styles/bootstrap-theme.min.css" />
</head>
<body >
	
	<h1 class="bg-primary text-white">Weather Instant Service</h1>
	<div class="container-fluid" class="bg-faded">
		<h4 ><strong>Login</strong></h4><hr>
		<table class="panel">
			<form:form method="post" modelAttribute="user" action="login">
				<tr>
					<td><label>Nombre: </label>
					<td>
						<form:input path="name"/>
						<form:errors path="name" class="bg-danger text-white"/>
					</td>
				</tr>
				<tr>
					<td><label>Contraseña: </label>
					<td>
						<form:input path="pass"/>
						<form:errors path="pass" class="bg-danger text-white"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input class="btn-primary" type="submit" value="Sign Up"></td>
				</tr>
	
			
			</form:form>
		</table>
		<span class="bg-danger text-white">${error}</span>
		<br><br>
		
		
		<a href="registerUser">Registrar nuevo usuario</a>
		</div>
		<script type="text/javascript" src="resources/scripts/jquery-3.2.1.min.js"></script>


<script type="text/javascript">

//resources/scripts/jquery-min.js


</script>
</body>
</html>