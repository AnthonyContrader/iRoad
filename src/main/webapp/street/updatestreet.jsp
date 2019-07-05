<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StreetDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Street</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
   <a href="SensorServlet?mode=sensorlist">Sensors</a>
    <a href="StreetServlet?mode=streetlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicle</a>
    <a href="ScreenServlet?mode=screenlist">Screens</a>
</div>
<br>
<div class="main">

<%StreetDTO s = (StreetDTO) request.getAttribute("dto");%>


<form id="floatleft" action="StreetServlet?mode=update&idstreet=<%=s.getIdStreet()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="street">Street Name </label>
    </div>
    <div class="col-75">
       <input type="text" id="user" name="username" value=<%=s.getStreetname()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Street Type</label>
    </div>
    <div class="col-75">
      <select id="type" name="streettype">
  				<option value="">..</option>
  				<option value="Autostrada">Autostrada</option>
  				<option value="Stradastatale">Strada statale</option>
  				<option value="Stradaregionale"> Strada regionale </option>
  				<option value="Stradaprovinciale">Strada provinciale</option>
  				<option value="Stradacomunale">Stradacomunale</option>
                 <option value="Stradaextraurbana ">Strada extraurbana</option>    
                   <option value="Stradaextraurbana ">Strada extraurbana</option> 
 
			</select> 
    </div>
  </div>
 
      <button type="submit" >Done</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>