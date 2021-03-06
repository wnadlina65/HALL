<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HALL | Login</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body style="background-image: url('assets/img/hallbg.png');">
	<style>
		blink {
		        animation: blinker 0.6s linear infinite;
		        color: black;
		       }
		      @keyframes blinker {
		        50% { opacity: 0; }
		       }
		       .blink-one {
		         animation: blinker-one 1s linear infinite;
		       }
		       @keyframes blinker-one {
		         0% { opacity: 0; }
		       }
		       .blink-two {
		         animation: blinker-two 1.4s linear infinite;
		       }
		       @keyframes blinker-two {
		         100% { opacity: 0; }
		       }
		
		       .center {
		        display: block;
		        margin-left: auto;
		        margin-right: auto;
		        width: 50%;
		      }
		      
				body {background-color: white;}
		</style>
		<div class="container align-content-center">
			<!-- Outer Row -->
		    <div class="row justify-content-center">
		
			<div class="col-xl-10 col-lg-12 col-md-9">
			<img src="assets/img/HALL1.png" width="250%" height="96%" class="center">
		  	<!-- Header -->
			<div class="card o-hidden border-0 shadow-lg my-5">
			    <div class="card-body p-0">
			            <!-- Nested Row within Card Body -->
			            <div class="row">
			              	<div  class="col-lg-6 d-none d-lg-block" height="100px" width="100px">
			                	<img src="assets/img/HALL.png" width="900%" height="600%" class="center">
			                </div>
			              <div class="col-lg-6">
			            		<div class="p-5">
			
			                      <div class="login-form" data-color="purple">
			                        <form name="loginform" method="post" action="index">
			                        	<h4>STAFF LOGIN</h4>
										<div class="form-group">
			                                <input type="text" class="form-control" placeholder="Enter staff ID" name="s_no" required="required">
			                            </div>
			                            <div class="form-group">
			                                <input type="password" class="form-control" placeholder="Password" name="s_pass" required="required">
			                            </div>
			                            <div class="form-group">
			                                <button type="submit" class="btn bg-info text-white btn-block" name="login">LOGIN</button>
			                            </div>
			                         </form>
								 </div>
			                  </div>
			                </div>
			              </div>
			            </div>
			          </div>
			        </div>
			 <div class="col-xl-10 col-lg-12 col-md-9">
			</div>
			</div>
		</div>
	<!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>
	<script>
		function setMsgId99(){
	        var id = '<% session.setAttribute("msgid","99"); %>';
	        out.write(id); 
	    }
	    function setMsgId100(){
	        var id = '<% session.setAttribute("msgid","100"); %>';
	        out.write(id); 
	    }
	</script>
</body>
</html>