<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ScreenDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Screen</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a class="active" href="ScreenServlet?mode=screenlist"><img width="15px" src="http://aux4.iconspalace.com/uploads/835558919617800347.png"> Back</a>
</div>
<br>
<div class="main">

<%ScreenDTO sc = (ScreenDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ScreenServlet?mode=update&idScreen=<%=sc.getIdScreen()%>" method="post">
  <div class="row">
    <div class="col-25">
     <label for="type">output</label>
    </div>
    <div class="col-75">
      <select id="type" name="output">
  				<option value="Attento Incidente">Attento Incidente</option>
  				<option value="Attento Vento Forte">Attento Vento Forte</option>
  				<option value="Attento un Veicolo non sta rispettando il semaforo">Attento un Veicolo non sta rispettando il semaforo</option>
 
			</select> 
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>