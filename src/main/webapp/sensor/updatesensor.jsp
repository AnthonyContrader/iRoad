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
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SensorDTO s = (SensorDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SensorServlet?mode=update&id=<%=s.getIdSensor()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor">SensorPosition</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor" name="SensorPosition" value=<%=s.getSensorPosition()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">SensorType</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="type" name="SensorType" value=<%=s.getSensorType()%>> 
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>