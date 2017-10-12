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
		<p>Congratulations!!! You are noy register with this data:</p>
		<ul>
			<li><label >Name: ${newUser.name}</label></li>
			<li><label >Email: ${newUser.email}</label></li>
			<li><label >Country: ${newUser.country}</label></li>
			<li><label>Date: ${newUser.date}</label></li>
		</ul>
	</div>
	<hr>
	<div>Now you can query the temperature of all countries in the world <a href ="/instantweatherapplication">here</a></div>
	<script type="text/javascript" src="resources/scripts/jquery-3.2.1.min.js"></script>


<script type="text/javascript">

	document.ready


</script>

</body>
</html>