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
    <a  href="ScreenServlet?mode=screenlist">Screens</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<StreetDTO> list = (List<StreetDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>Street Name</th>
			
			<th>Street Type</th>
		     <th>ID </th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (StreetDTO s : list) {
		%>
		<tr>
			<td><a href=StreetServlet?mode=read&idstreet=<%=s.getIdStreet()%>>
			    <%=s.getStreetname()%>
			</a></td>
			<td><%=s.getStreettype()%></td>
			<td><%=s.getIdStreet()%></td>
			
			
			<td><a href=StreetServlet?mode=read&update=true&idstreet=<%=s.getIdStreet()%>><img width="20px" src="http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Edit-File-icon.png"></a>
			</td>
			<td><a href=StreetServlet?mode=delete&idstreet=<%=s.getIdStreet()%>><img width="20px" src="https://img.icons8.com/cotton/2x/delete-sign--v2.png"></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="StreetServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="street">Street Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="street" name="streetname" placeholder="inserisci il Nome della strada">
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
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>