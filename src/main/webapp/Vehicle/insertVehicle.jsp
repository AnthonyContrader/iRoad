<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert vehicle</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Insert Vehicle</title>

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
            <a href="/Doctor/vehicleManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>Vehicle Management</span>
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
            <h3 class="page-header"><i class="fa fa-laptop"></i> Insert Vehicle</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home </li>
              <li><i class="fa fa-laptop"></i>Insert Vehicle</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form action="/Vehicle/creaVehicle" method="post" class="register" novalidate="novalidate">
      
		      <p class="form-row-wide">
		        <label for="reg_namevehicle"> Name Vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="namevehicle" id="namevehicle" placeholder="inserisci namevehicle" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_typevehicle">Type vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="typevehicle" id="typevehicle" placeholder="inserisci typevehicle" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_speedvehicle">Speed vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="speedvehicle" id="speedvehicle" placeholder="inserisci speedvehicle" value="" required="">
		      </p>
		
		      <p class="form-row-wide">
		        <label for="reg_weightvehicle">Weight vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="" id="weightvehicle" placeholder="inserisci weightvehicle" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_longvehicle">Long vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="longvehicle" id="longvehicle" placeholder="inserisci longvehicle" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_latvehicle">Lat vehicle <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="latvehicle" id="latvehicle" placeholder="inserisci latvehicle" value="" required="">
		      </p>
		      
		      
		          <p class="form-row">
		              <button class="btn btn-lg btn-primary btn-block" type="submit"> Aggiungi un vehicle</button>
		          <div class="invalid-feedback">This field is required</div> </p>


      </form>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="/Home/Vehicle/vehicleManagement">Back</a>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>

  
</body>
</html>