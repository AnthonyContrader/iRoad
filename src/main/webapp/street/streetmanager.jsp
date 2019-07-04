<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StreetDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Street Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="SensorServlet?mode=sensorlist">Sensors</a>
   <a class="active" href="StreetServlet?mode=streetlist">Streets</a>
    <a href="VehicleServlet?mode=vehiclelist">Vehicles</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<StreetDTO> list = (List<StreetDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>StreetType</th>
			
			<th>StreetName</th>
		     <th>ID </th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (StreetDTO s : list) {
		%>
		<tr>
			<td><a href=StreetServlet?mode=read&idStreet=<%=s.getIdstreet()%>>
					<%=s.getStreettype()%>
			</a></td>
			<td><%=s.getStreetname()%></td>
			<td><%=s.getIdstreet()%></td>
			
			
			<td><a href=StreetServlet?mode=read&update=true&idStreet=<%=s.getIdstreet()%>>Edit</a>
			</td>
			<td><a href=StreetServlet?mode=delete&idStreet=<%=s.getIdstreet()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="StreetServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor">StreetName</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor" name="StreetName" placeholder="inserisci il Nome della strada">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">StreetType</label>
    </div>
    <div class="col-75">
 			<select id="type" name="StreetType">
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