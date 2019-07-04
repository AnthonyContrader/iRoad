<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ScreenDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
   <a href="SensorServlet?mode=sensorlist">Sensors</a>
    <a href="SreetServlet?mode=userlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicle</a>
</div>
<br>
<div class="main">

<%ScreenDTO sc = (ScreenDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SensorServlet?mode=update&idSensor=<%=sc.getIdScreen()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor">SensorPosition</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor" name="output" value=<%=sc.getOutput()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">SensorType</label>
    </div>
    <div class="col-75">
      <select id="type" name="sensortype">
  				<option value="autovelox">Autovelox</option>
  				<option value="anemometro">Anemometro</option>
  				<option value="dinamometro">Dinamometro</option>
 
			</select> 
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>