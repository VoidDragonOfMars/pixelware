<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather App</title>
<link rel="stylesheet" href="resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="resources/styles/bootstrap-theme.min.css" />
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body >
	<div class="container-fluid" class="bg-faded">
	<h1 class="bg-primary text-white">Weather Instant Service</h1>
	<div class="row">
		<div class="col-sm-4">
			<table class ="panel">
				<tr>
					<td><strong>Bienvenido ${userLogin.name}</strong></td>
				</tr>
				<tr>
					<td>Sign out <a href="/instantweatherapplication/logout">here</a></td>
				</tr>
			</table>
			<hr>
			<table class="panel">
				<form:form method="post" modelAttribute="report" action="/instantweatherapplication/getReport" id="formReport">
					<tr>
						<td><label >Ciudad</label>
						<td><form:input path="city" class="autocomplete" id="cities"/>
						<form:errors class="bg-danger text-white" path="city"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="btn-primary" type="submit" value="Obtener Pronóstico"></td>
					</tr>
		
				</form:form>
			</table>
			<hr>
			<div  class="label-danger">${error}</div>
			
			<div class="label-success">${mensaje}</div>
			
		</div>
		
			<div class="col-sm-4" class="panel">
				<table class="table">
					<thead>
						<th>Ciudad</th>
						<th>Temperatura</th>
					</thead>
					<tbody>
						<c:forEach items="${userLogin.reports}" var="report">
							<tr >
								<td><label >${report.city}</label></td>
								<td >${report.temperature} ºC</td>
							</tr>	
						</c:forEach>
					</tbody>				
				</table>
			</div>
			<div class="cols-sm-4"></div>
		</div>
		</div>
<script type="text/javascript" src="resources/scripts/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	var cities = [];

	
	 $.ajax({
         type : "GET",
         url : "http://services.groupkt.com/country/get/all",
         dataType : "json",
         data : null,                    
         success:function(object){
          
             for(var i=0; i < object.RestResponse.result.length; i++){
            	
            	cities.push(object.RestResponse.result[i].name);
            }
            
         },
         error:function(msg){
             console.log("failed");
         }
     });
	 
	 
	 $( "#cities" ).autocomplete({
	      source: cities
	    });
});


</script>



	
</body>
</html>