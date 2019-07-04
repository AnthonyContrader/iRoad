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
		List<ScreenDTO> list = (List<ScreenDTO>)request.getAttribute("list");
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
			for (ScreenDTO sc : list) {
		%>
		<tr>
			<td><a href=ScreenServlet?mode=read&idScreen=<%=sc.getIdScreen()%>>
					<%=sc.getOutput()%>
			</a></td>
			<td><%=sc.getIdScreen()%></td>
			
			
			<td><a href=ScreenServlet?mode=read&update=true&idScreen=<%=sc.getIdScreen()%>><img width="20px" src="http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Edit-File-icon.png"></a>
			</td>
			<td><a href=ScreenServlet?mode=delete&idScreen=<%=sc.getIdScreen()%>><img width="20px" src="https://img.icons8.com/cotton/2x/delete-sign--v2.png"></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ScreenServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="screen">output</label>
    </div>
    <div class="col-75">
     <select id="type" name="output">
  				<option value="Attento Incidente">Attento Incidente</option>
  				<option value="Attento Vento Forte">Attento Vento Forte</option>
  				<option value="Attento un Veicolo non sta rispettando il semaforo">Attento un Veicolo non sta rispettando il semaforo</option>
 
			</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
    </div>
    <div class="col-75">
 			
    	</div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>