<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login iRoad</title>

</head>
<body style="background-image: url('http://www.motivi.mk/wp-content/themes/jobcareer/backend/assets/images/background/bg6.png'); background-size : 150%">



<div class="main" >

		<form class="login" action="LoginServlet" method="post">
		
<img src="http://zellwax.com/wp-content/uploads/2016/07/road-marking.png" width="100" height="100" style="margin-left: 120px" />
				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username">
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

</div>

</body>
</html>