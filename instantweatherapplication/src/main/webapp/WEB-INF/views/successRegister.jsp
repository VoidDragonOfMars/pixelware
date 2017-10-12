<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="resources/styles/bootstrap-theme.min.css" />
</head>
<body>


	<h1 class="bg-primary text-white">Weather Instant Service</h1>
	
	<div class="panel"><hr>
		<p>Felicidades!!! te has registado como usuario con los siguientes datos:</p>
		<ul>
			<li><label >Nombre: ${newUser.name}</label></li>
			<li><label >Email: ${newUser.email}</label></li>
			<li><label >País: ${newUser.country}</label></li>
			<li><label>Fecha: ${newUser.date}</label></li>
		</ul>
	</div>
	<hr>
	<div>Ahora ya puedes consultar el tiempo en cualquier ciudad pulsando <a href ="/instantweatherapplication">aquí</a></div>
	<script type="text/javascript" src="resources/scripts/jquery-3.2.1.min.js"></script>


<script type="text/javascript">

	document.ready


</script>

</body>
</html>