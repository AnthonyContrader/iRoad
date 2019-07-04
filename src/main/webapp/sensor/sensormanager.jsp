<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SensorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Sensor Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="SensorServlet?mode=sensorlist">Sensors</a>
   <a href="StreetServlet?mode=streetlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicles</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<SensorDTO> list = (List<SensorDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>SensorType</th>
			
			<th>SensorPosition</th>
		     <th>idSensor</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (SensorDTO s : list) {
		%>
		<tr>
			<td><a href=SensorServlet?mode=read&idSensor=<%=s.getIdSensor()%>>
					<%=s.getSensorType()%>
			</a></td>
			<td><%=s.getSensorPosition()%></td>
			<td><%=s.getIdSensor()%></td>
			
			
			<td><a href=SensorServlet?mode=read&update=true&idSensor=<%=s.getIdSensor()%>><img width="20px" src="http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Edit-File-icon.png"></a>
			</td>
			<td><a href=SensorServlet?mode=delete&idSensor=<%=s.getIdSensor()%>><img width="20px" src="https://img.icons8.com/cotton/2x/delete-sign--v2.png"></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="SensorServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor">SensorPosition</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor" name="sensorPosition" placeholder="inserisci la posizione del sensore">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">SensorType</label>
    </div>
    <div class="col-75">
 			<select id="type" name="sensorType">
  				<option value="autovelox">Autovelox</option>
  				<option value="anemometro">Anemometro</option>
  				<option value="dinamometro">Dinamometro</option>
 
			</select>
    	</div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>