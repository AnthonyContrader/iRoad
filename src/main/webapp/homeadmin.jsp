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
    <a href="ScreenServlet?mode=SCREENLIST">Screens</a>
    
  
  <a href="LogoutServlet" id="logout">Logout</a>
   <a href="" id="logout"> Profil of ${user.getUsername()}</a>
</div>

<div class="main" >
<h1></h1>
	<div class="row"> 
			<div class="col-25">
			
			<img alt="center" src="https://image.freepik.com/free-vector/infographic-timeline-concept-with-road_23-2147861210.jpg">
			</div >
			<div class="col-70">
			<p><h3> Il TEAM ricerca e sviluppo di iRoad vi da il benvenuto!
			Stanco delle solite applicazioni da pochi spiccioli? Da oggi si cambia!</h3><p>
		    	   
		    <p><h1>WORK IN PROGRESS BY </h1>  <p>
		    _____________________________________________________________________________	
		    <h2>
		    
		     ANTONIO Tunzi, ANES Bend, RIRCCARDO De Vecchis, MAJID Alamdari, DAVIDE Bologna.</h2><p>
		   
		    ______________________________________________________________________________
		    
		    <p><h1>..COOMING SOON!!!..</h1><p >
		    
			  </p>
			</div>

			</div>
	</div> 



<%@ include file="css/footer.jsp" %>

</body>
</html>