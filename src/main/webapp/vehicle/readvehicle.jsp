<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.VehicleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Vehicle</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="VehicleServlet?mode=vehiclelist">Vehicle</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%VehicleDTO v = (VehicleDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Nome Veicolo</th>
			<th>Tipologia</th>
			<th>Velocità</th>
			<th>Peso</th>
			<th>Longitudine</th>
			<th>Latitudine</th>
	</tr>
	<tr>
		<td><%=v.getNameVehicle()%></td>
		<td> <%=v.getTypeVehicle()%></td>
		<td><%=v.getSpeedVehicle()%></td>
			<td><%=v.getWeightVehicle()%></td>
			<td><%=v.getLatVehicle()%></td>
			<td><%=v.getLongVehicle()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>