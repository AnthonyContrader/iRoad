<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.SensorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sensor Management</title>
	<%
	List<SensorDTO> AllSensor = (List<SensorDTO>) request.getAttribute("allSensorDTO");
	 %>
	 
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Sensor management</title>


</head>
<body>
	  <!-- container section start -->
  <section id="container" class="">


    <header class="header dark-bg">
      <div class="toggle-nav">
       
      </div>

      <!--logo start-->
      <a href="/home.jsp" class="logo">iRoad</a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="sensorType">${utenteCollegato.sensorType}</span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
             
              <li>
                <a href="/Admin/logout"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="sub-menu">
            <a class="" href="/homeAdmin.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Dashboard</span>
                      </a>
          </li>
          <li class="active">
            <a href="/Admin/SensorManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>Sensor Management</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="/Admin/SensorManagement" class="">
                          <i class="icon_desktop"></i>
                          <span>Sensor management</span>
                      </a>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Sensor Management</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home</li>
              <li><i class="fa fa-laptop"></i>Sensor Management</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            	<table class="table table-striped">
					<tr><th>SensorId</th><th>LongSensor</th><th>LatSensor</th><th>SensorType</th><th colspan=2>Option</th></tr>
						<%
							for(SensorDTO sensor:AllSensor){
						 %>
		 			<tr>
		 				<td><%=sensor.getIdSensor()%></td>
		 				<td><%=sensor.getLongSensor()%></td>
		 				<td><%=sensor.getLatSensor()%></td>
		 				<td><%=sensor.getSensorType()%></td>
		 			    <td><a  href="/Sensor/redirectUpdate?idSensor=<%=sensor.getIdSensor() %>">Edit</a></td> 
		 				<td><a  href="/Sensor/delete?idSensor=<%=sensor.getIdSensor() %>">Delete</a></td>
		 			
		 			</tr>
						<% 
							}
						%>
				</table>
				<a  href="/Sensor/insertSensor.jsp">Insert Sensor</a>
				<br>
				<br>
				
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->


    
</body>
</html>