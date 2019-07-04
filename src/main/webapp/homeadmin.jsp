<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iRoad Home | Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
   <a href="SensorServlet?mode=sensorlist">Sensors</a>
    <a href="StreetServlet?mode=streetlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicles</a>
    <a href="ScreentServlet?mode=screenlist">Screens</a>
    
  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main" >
<h1>Welcome ${user.getUsername()}</h1>
	<div class="row"> 
			<div class="col-25">
			<img alt="center" src="https://image.freepik.com/free-vector/infographic-timeline-concept-with-road_23-2147861210.jpg">
			</div >
			<div class="col-70">
			<p> Il TEAM ricerca e sviluppo di iRoad vi da il benvenuto!<p>
			Stanco delle solite applicazioni da pochi spiccioli? Da oggi si cambia!<p>
		    ---------------------------------------------------------		   
		    <p> (WORK IN PROGRES) By <p>
		    Antonio Tunzi, Anes Bend, Riccardo De Vecchis, Mjid Alamdari, Davide Bologna.<p>
		    <p>
		    ---------------------------------------------------------
		    
		    <p>..[COOMING SOON]..<p >
		    
			  </p>
			</div>

			</div>
	</div> 



<%@ include file="css/footer.jsp" %>

</body>
</html>