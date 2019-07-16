<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.VehicleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Management</title>
	<%
	List<VehicleDTO> AllVehicle = (List<VehicleDTO>) request.getAttribute("allVehicleDTO");
	 %>
	 
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Vehicle management</title>


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
                            <span class="namevehicle">${utenteCollegato.namevehicle}</span>
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
            <a href="/Admin/VehicleManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>Vehicle Management</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="/Admin/vehicleManagement" class="">
                          <i class="icon_desktop"></i>
                          <span>Vehicle management</span>
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
            <h3 class="page-header"><i class="fa fa-laptop"></i> Vehicle Management</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home</li>
              <li><i class="fa fa-laptop"></i>Vehicle Management</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            	<table class="table table-striped">
					<tr><th>VehicleId</th><th>NameVehicle</th><th>TypeVehicle</th><th>SpeedVehicle</th><th>WeightVehicle</th><th>LongVehicle</th><th>LatVehicle</th><th colspan=2>Option</th></tr>
						<%
							for(VehicleDTO vehicle:AllVehicle){
						 %>
		 			<tr>
		 				<td><%=vehicle.getIdVehicle()%></td>
		 				<td><%=vehicle.getNameVehicle()%></td>
		 				<td><%=vehicle.getTypeVehicle()%></td>
		 				<td><%=vehicle.getSpeedVehicle()%></td>
		 				<td><%=vehicle.getWeightVehicle()%></td>
		 				<td><%=vehicle.getLongVehicle()%></td>
		 				<td><%=vehicle.getLatVehicle()%></td>
		 				
		 			    <td><a  href="/Vehicle/redirectUpdate?idVehicle=<%=vehicle.getIdVehicle() %>">Edit</a></td> 
		 				<td><a  href="/Vehicle/delete?idVehicle=<%=vehicle.getIdVehicle() %>">Delete</a></td>
		 			
		 			</tr>
						<% 
							}
						%>
				</table>
				<a  href="/Vehicle/insertVehicle.jsp">Insert Vehicle</a>
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