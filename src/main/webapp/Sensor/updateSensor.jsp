    
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>EDIT PAGE</title>
</head>

<body class="text-center">

  
  <%
	SensorDTO s = (SensorDTO) request.getAttribute("sensor");
%>
  
  <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/Sensor/update">
			<input type="hidden" name="sensorType" value="<%=s.getSensorType()%>" />
			<input type="hidden" name="longSensor" value="<%=s.getLongSensor()%>" />
			<input type="hidden" name="latSensor" value="<%=s.getLatSensor()%>" />
			
			<table class="table">

			<tr>
				<td><b>SensorType:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="sensorType" value="<%=s.getSensorType()%>" /></td>
			</tr>
			<tr>
				<td><b>LongSensor:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="longSensor" value="<%=s.getLongSensor()%>" /></td>
			</tr>
			<tr>
				<td><b>LatSensor:</b></td> 
				<td> <input type="latSensor" size="40" maxlength="40" name="latSensor" value="<%=s.getLatSensor()%>" /></td>
			</tr>
			
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/Home/sensorManagement">Back</a>

		</form>
            </div>
        </div>>