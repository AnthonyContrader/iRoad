<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert user</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Insert User</title>

</head>
<body>
	  <!-- container section start -->
  <section id="container" class="">


    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="/homeAdmin.jsp" class="logo">IRoad</a>
      <!--logo end-->

    
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="sub-menu">
            <a class="" href="/homeDoctor.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Dashboard</span>
                      </a>
          </li>
          <li class="active">
            <a href="/Doctor/userManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>User Management</span>
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
            <h3 class="page-header"><i class="fa fa-laptop"></i> Insert User</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home </li>
              <li><i class="fa fa-laptop"></i>Insert User</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form class="insert-form" action="/Admin/creaUser" method="post">
		<table>
			
			
			<tr>
				<td>User name</td><td><input type="text" name="user_user" placeholder="username"></td>
			</tr>
			
			<tr>
				<td>Password</td><td><input type="password" name="password" placeholder="password"></td>
			</tr>
			
			<tr>
				<td>User type </td><td><input type="text" name="usertype" placeholder="usertype"></td>
			</tr>
			
			
		</table>
		<br>
		<button class="btn btn-primary btn-lg btn-block" type="submit">Insert</button>
	</form>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="/Admin/userManagement">Back</a>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>

  
</body>
</html>