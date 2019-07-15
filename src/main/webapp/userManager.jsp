<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
	<%
		List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("User");
	 %>
	 
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>User management</title>


</head>
<body>
	  <!-- container section start -->
  <section id="container" class="">


    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="/homeAdmin.jsp" class="logo">iRoad</a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="username">${utenteCollegato}</span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
             
              <li>
                <a href="/User/logout"><i class="icon_key_alt"></i> Log Out</a>
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
            <a href="/Admin/UserManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>User Management</span>
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
            <h3 class="page-header"><i class="fa fa-laptop"></i> User Management</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home</li>
              <li><i class="fa fa-laptop"></i>User Management</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            	<table class="table table-striped">
					<tr><th>UserId</th><th>Username</th><th>Password</th><th>Type</th><th colspan=2>Option</th></tr>
						<%
							for(UserDTO user: listUser){
						 %>
		 			<tr>
		 				<td><%=user.getIdUser()%></td>
		 				<td><%=user.getUsername()%></td>
		 	

		 				<td><%=user.getPassword()%></td>
		 				<td><%=user.getUsertype()%></td>
		 			
		 				<td><a  href="/Admin/deleteDoctor?id=<%=user.getIdUser() %>">Delete</a></td>
		 			<td><a  href="/Admin/redirectUpdate?id=<%=user.getIdUser() %>">Delete</a></td>
		 			</tr>
						<% 
							}
						%>
				</table>
				<a  href="/insertUser.jsp/">Insert User</a>
				<br>
				<br>
				<a  href="/homeAdmin.jsp">Back</a>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->


    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });
      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true
        });
      });
      //custom select box
      $(function() {
        $('select.styled').customSelect();
      });
      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>
</body>
</html>