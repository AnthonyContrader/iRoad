<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StreetDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Sensor</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="StreetServlet?mode=streetlist"><img width="15px" src="http://aux4.iconspalace.com/uploads/835558919617800347.png"> Back</a>
  <a class="active"  href="StreetServlet?mode=streetlist">Street</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<% StreetDTO s = (StreetDTO) request.getAttribute("dto");%>


<table>
	<tr> 
	
		<th>Street Name</th>
			
			<th>Street Type</th>
		     <th>ID </th>
	</tr>
	<tr>
		
		<td> <%=s.getStreetname()%></td>
		<td> <%=s.getStreettype()%></td>
		<td> <%=s.getIdStreet()%></td>
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