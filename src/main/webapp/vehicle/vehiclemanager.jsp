<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.VehicleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
   <a href="SensorServlet?mode=sensorlist">Sensors</a>
    <a href="StreetServlet?mode=streetlist">Streets</a>
    <a class="active" href="VehicleServlet?mode=vehiclelist">Vehicle</a>
    <a href="ScreenServlet?mode=screenlist">Screens</a>
  
  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<VehicleDTO> list = (List<VehicleDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Nome Veicolo</th>
			<th>Tipologia</th>
			<th>Velocità</th>
			<th>Peso</th>
			<th>Longitudine</th>
			<th>Latitudine</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (VehicleDTO v : list) {
		%>
		<tr>
			<td><a href=VehicleServlet?mode=read&idVehicle=<%=v.getIdVehicle()%>>
					<%=v.getNameVehicle()%>
			</a></td>
			<td><%=v.getTypeVehicle()%></td>
			<td><%=v.getSpeedVehicle()%></td>
			<td><%=v.getWeightVehicle()%></td>
			<td><%=v.getLatVehicle()%></td>
			<td><%=v.getLongVehicle()%></td>
			<td><a href=VehicleServlet?mode=read&update=true&idVehicle=<%=v.getIdVehicle()%>>Edit</a>
			</td>
			<td><a href=VehicleServlet?mode=delete&idVehicle=<%=v.getIdVehicle()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="VehicleServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="vehicle">Nome Veicolo</label>
    </div>
    <div class="col-75">
      <input type="text" id="vehicle" name="nameVehicle" placeholder="inserisci il nome del veicolo">
    </div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="type">Tipologia</label>
    </div>
    <div class="col-75">
 			<select id="type" name="typeVehicle">
  				<option value="automobile">Automobile</option>
  				<option value="motociclo">Motociclo</option>
  				<option value="camion">Camion</option>
  				<option value="bus">Bus</option>
 
			</select>
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="speed">Velocità</label>
    </div>
    <div class="col-75">
      <input type="text" id="speed" name="speedVehicle" placeholder="inserisci la velocita' del veicolo">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="weight">Peso</label>
    </div>
    <div class="col-75">
      <input type="text" id="weight" name="weightVehicle" placeholder="inserisci il peso del veicolo">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="lat">Latitudine</label>
    </div>
    <div class="col-75">
      <input type="text" id="lat" name="LatVehicle" placeholder="inserisci latitudine">
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="long">Longitudine</label>
    </div>
    <div class="col-75">
      <input type="text" id="long" name="LongVehicle" placeholder="inserisci longitudine">
    </div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>