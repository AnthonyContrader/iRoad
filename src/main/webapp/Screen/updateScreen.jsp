    
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
	ScreenDTO s = (ScreenDTO) request.getAttribute("screen");
%>
  
  <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/Screen/update">
			<input type="hidden" name="output" value="<%=s.getOutput()%>" />
			
			<table class="table">

			<tr>
				<td><b>Output:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="output" value="<%=s.getOutput()%>" /></td>
			</tr>		
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/Home/outputManagement">Back</a>

		</form>
            </div>
        </div>>