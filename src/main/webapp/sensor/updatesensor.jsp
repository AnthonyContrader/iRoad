<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SensorDTO"%>
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
  
   <a class="active" href="SensorServlet?mode=sensorlist">Sensors</a>
   <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SensorDTO s = (SensorDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SensorServlet?mode=update&idSensor=<%=s.getIdSensor()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor">SensorPosition</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor" name="sensorPosition" value=<%=s.getSensorPosition()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">SensorType</label>
    </div>
    <div class="col-75">
      <select id="type" name="sensorType">
  				<option value="Autovelox" <%if(s.getSensorType().equals("Autovelox")) {%>selected<%}%> >Autovelox</option>
  				<option value="Anemometro" <%if(s.getSensorType().equals("Anemometro")) {%>selected<%}%> >Anemometro</option>
  				<option value="Dinamometro" <%if(s.getSensorType().equals("Dinamometro")) {%>selected<%}%>>Dinamometro</option>
 
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