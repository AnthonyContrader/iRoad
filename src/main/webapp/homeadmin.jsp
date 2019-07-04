<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iRaod Home | Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
   <a href="SensorServlet?mode=sensorlist">Sensors</a>
    <a href="SreetServlet?mode=userlist">Streets</a>
    
  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main" >
<h1>Welcome ${user.getUsername()}</h1>
	<div class="row"> 
			<div class="col-25">
			<img alt="center" src="https://image.freepik.com/free-vector/infographic-timeline-concept-with-road_23-2147861210.jpg">
			</div >
			<div class="col-70">
			<p> Lorem Ipsum è un testo segnaposto utilizzato nel settore della tipografia e della stampa. Lorem Ipsum 
				è considerato il testo segnaposto standard sin dal sedicesimo secolo, quando un anonimo tipografo prese 
					una cassetta di caratteri e li assemblò per preparare un testo campione. È sopravvissuto non solo a più 
				di cinque secoli, ma anche al passaggio alla videoimpaginazione, pervenendoci sostanzialmente inalterato.
 				Fu reso popolare, negli anni ’60, con la diffusione dei fogli di caratteri trasferibili “Letraset”, che 
 				contenevano passaggi del Lorem Ipsum, e più recentemente da software di impaginazione come Aldus PageMaker, </p>
			</div>

			</div>
	</div> 



<%@ include file="css/footer.jsp" %>

</body>
</html>