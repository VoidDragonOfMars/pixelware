<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	
		<h1 class="bg-primary text-white">Weather Instant Service</h1>
	<div class="container">	
	<div class="row"><h4><strong>Register new users</strong></h4>
	
		<table class="cols-sm-3">
		<hr>
			<form:form method="post" modelAttribute="newUser" action="registerUser">
				<tr>
					<td><label>Name:</label></td>
					<td>
						<form:input path="name"/>
						<form:errors path="name"  class="bg-danger text-white"/>
					</td>	
				</tr>
				<tr>
					<td><label>Email: </label></td>
					<td>
						<form:input path="email"/>
						<form:errors path="email"  class="bg-danger text-white"/>
					</td>
				</tr>
					<td><label>Date : </label></td>
					<td>
						<form:input path="date"/>
						<form:errors path="date"  class="bg-danger text-white"/>
					</td>				
				<tr>
					<td><label>Country: </label></td>
					<td>
						<form:input path="country" id="cities"/>
						<form:errors path="country"  class="bg-danger text-white"/>
					</td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td>
						<form:input path="pass"/>
						<form:errors path="pass"  class="bg-danger text-white"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input class="btn-primary" type="submit" value="Register"></td>
				</tr>
			
			</form:form>
		
		
		</table>
		</div>
		
			<div class="label-danger">${error}</div>
		
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