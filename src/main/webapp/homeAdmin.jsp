<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	%>
	<%@	page import="it.contrader.dto.UserDTO"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iRoad Home | ${utenteCollegato.username}</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>



<div >
  <a class="active" href="/homeAdmin.jsp">Dashboard</a>
  <a href="/Admin/userManagement">Users</a>
   <a href="/Admin/vehicleManagement">Vehicles</a>
   <a href="/Admin/sensorManagement">Sensors</a>
    <a href="/Admin/streetManagement">Streets</a>
   
    <a href="/Admin/screenManagement">Screens</a>
     <a href="/Admin/signalManagement">Signals</a>
    
  
</div>
<div  style=" margin-left: 1000px">
  <a href="Admin/logout" >Logout</a>
   <a href=""  > CIAO ${utenteCollegato.username}</a>
   </div>

<div class="main" >
<h1></h1>
	<div class="row"> 
	<div class="col-70" >

		    <h3> Il TEAM ricerca e sviluppo di iRoad vi da il benvenuto!
			Stanco delle solite applicazioni da pochi spiccioli? Da oggi si cambia!</h3> 
		    
		  <p><h2>
		    
		     ANTONIO Tunzi, ANES Bend, RICCARDO De Vecchis, MAJID Alamdari, DAVIDE Bologna.</h2><p>

			</div>

			</div>
	</div> 



</body>
</html>