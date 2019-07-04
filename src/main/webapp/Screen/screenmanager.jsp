<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ScreenDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Screen Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="SensorServlet?mode=sensorlist">Sensors</a>
   <a href="StreetServlet?mode=streetlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicles</a>
     <a class="active" href="ScreenServlet?mode=screenlist">Screens</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ScreenDTO> list = (List<ScreenDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>OUTPUT MESSAGES</th>
		     <th>ID </th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ScreenDTO s : list) {
		%>
		<tr>
			<td><a href=ScreenServlet?mode=read&idStreet=<%=s.getIdScreen()%>>
					<%=s.getOutput()%>
			</a></td>
			<td><%=s.getIdScreen()%></td>
			
			
			<td><a href=ScreenServlet?mode=read&update=true&idScreen=<%=s.getIdScreen()%>>Edit</a>
			</td>
			<td><a href=ScreenServlet?mode=delete&idScreen=<%=s.getIdScreen()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ScreenServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="screen">ScreenName</label>
    </div>
    <div class="col-75">
      <input type="text" id="screen" name="output" placeholder="inserisci l'output da visualizzare">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
    </div>
    <div class="col-75">
 			<select id="type" name="output">
  				<option value="Attento Incidente">Attento Incidente</option>
  				<option value="Attento Vento Forte">Attento Vento Forte</option>
  				<option value="Attento un Veicolo non sta rispettando il semaforo">Attento un Veicolo non sta rispettando il semaforo</option>
 
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