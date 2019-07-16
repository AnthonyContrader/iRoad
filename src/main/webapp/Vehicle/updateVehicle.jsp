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
	VehicleDTO v = (VehicleDTO) request.getAttribute("vehicle");
%>
  
  <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/Vehicle/update">
			<input type="hidden" name="namevehicle" value="<%=v.getNameVehicle()%>" />
			<input type="hidden" name="typevehicle" value="<%=v.getTypeVehicle()%>" />
			<input type="hidden" name="speedvehicle" value="<%=v.getSpeedVehicle()%>" />
			<input type="hidden" name="weightvehicle" value="<%=v.getWeightVehicle()%>" />
			<input type="hidden" name="longvehicle" value="<%=v.getLongVehicle()%>" />
			<input type="hidden" name="latvehicle" value="<%=v.getLatVehicle()%>" />
			<table class="table">

			<tr>
				<td><b>NameVehicle:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="bamevehicle" value="<%=v.getNameVehicle()%>" /></td>
			</tr>
			
			<tr>
				<td><b>TypeVehicle:</b></td> 
				<td> <input type="typevehicle" size="40" maxlength="40" name="typevehicle" value="<%=v.getTypeVehicle()%>" /></td>
			</tr>
			
            <tr>
				<td><b>WeightVehicle:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="weightvehicle" value="<%=v.getWeightVehicle()%>" /></td>
			<tr>
				
			<tr>
			    <td><b>LongVehicle:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="longvehicle" value="<%=v.getLongVehicle()%>" /></td>
			</tr>
			
			<tr>
			    <td><b>LatVehicle:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="latvehicle" value="<%=v.getLatVehicle()%>" /></td>
			</tr>
			
			
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/Home/vehicleManagement">Back</a>

		</form>
            </div>
        </div>>