<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HALL | Home</title>

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
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	* {box-sizing: border-box}
	body {font-family: Verdana, sans-serif; margin:0}
	
	/* Slideshow container */
	.slideshow-container {
	  position: relative;
	  background: #DDA0DD;
	}
	
	/* Slides */
	.mySlides {
	  display: none;
	  padding: 80px;
	  text-align: center;
	}
	
	/* Next & previous buttons */
	.prev, .next {
	  cursor: pointer;
	  position: absolute;
	  top: 50%;
	  width: auto;
	  margin-top: -30px;
	  padding: 16px;
	  color: #888;
	  font-weight: bold;
	  font-size: 20px;
	  border-radius: 0 3px 3px 0;
	  user-select: none;
	}
	
	/* Position the "next button" to the right */
	.next {
	  position: absolute;
	  right: 0;
	  border-radius: 3px 0 0 3px;
	}
	
	/* On hover, add a black background color with a little bit see-through */
	.prev:hover, .next:hover {
	  background-color: rgba(0,0,0,0.8);
	  color: white;
	}
	
	/* The dot/bullet/indicator container */
	.dot-container {
	    text-align: center;
	    padding: 20px;
	    background: #ddd;
	}
	
	/* The dots/bullets/indicators */
	.dot {
	  cursor: pointer;
	  height: 15px;
	  width: 15px;
	  margin: 0 2px;
	  background-color: #bbb;
	  border-radius: 50%;
	  display: inline-block;
	  transition: background-color 0.6s ease;
	}
	
	/* Add a background color to the active dot/circle */
	.active, .dot:hover {
	  background-color: #717171;
	}
	
	/* Add an italic font style to all quotes */
	q {font-style: italic;}
	
	/* Add a blue color to the author */
	.author {color: cornflowerblue;}
	</style>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="white" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="index.jsp" class="simple-text">
                    HALL
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="index.jsp">
                        <i class="pe-7s-home"></i>
                        <p>Home</p>
                    </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-id"></i>
                       	<p>Staff<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
	                      <li><a href="stafflist.jsp" onclick="setMsgId99()">List of Staff</a></li>
	                      <li class="divider"></li>
	                      <li><a href="addstaff.jsp" onclick="setMsgId99()">Add Staff</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-culture"></i>
                       	<p>Hall<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      <li><a href="hall.jsp" onclick="setMsgId99()">List of Hall</a></li>
                      <li class="divider"></li>
                      <li><a href="addhall.jsp" onclick="setMsgId99()">Add Hall</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-users"></i>
                       	<p>Customer<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      	<li><a href="customer.jsp" onclick="setMsgId99()">List of Customer</a></li>
                      	<li class="divider"></li>
                   	   	<li><a href="addcustomer.jsp" onclick="setMsgId99()">Add Customer</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-note2"></i>
                       	<p>Booking<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      	<li><a href="bookinglist.jsp" onclick="setMsgId99()">Booking List</a></li>
                      	<li class="divider"></li>
                   	   	<li><a href="booking.jsp" onclick="setMsgId99()">Add Booking</a></li>
                    </ul>
                </li>
                <!--<li class="separator hidden-lg"></li>-->
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="">
                                <i class="fa fa-search"></i>
								<p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										<center>
											<%
												String name = (String) session.getAttribute("firstName");
												String no = (String) session.getAttribute("sno");
											%>
											Welcome <%=name%>
										</center>
										<b class="caret"></b>
									</p>

                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="login.jsp" onclick="setMsgId100()">Logout</a></li>
                              </ul>
                        </li>
                        <li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                	<div class="slideshow-container">

				<div class="mySlides">
				  <q>I love you the more in that I believe you had liked me for my own sake and for nothing else</q>
				  <p class="author">- John Keats</p>
				</div>
				
				<div class="mySlides">
				  <q>But man is not made for defeat. A man can be destroyed but not defeated.</q>
				  <p class="author">- Ernest Hemingway</p>
				</div>
				
				<div class="mySlides">
				  <q>I have not failed. I've just found 10,000 ways that won't work.</q>
				  <p class="author">- Thomas A. Edison</p>
				</div>
				
				<a class="prev" onclick="plusSlides(-1)">❮</a>
				<a class="next" onclick="plusSlides(1)">❯</a>
				
				</div>
				
				<div class="dot-container">
				  <span class="dot" onclick="currentSlide(1)"></span> 
				  <span class="dot" onclick="currentSlide(2)"></span> 
				  <span class="dot" onclick="currentSlide(3)"></span> 
				</div>
                </div>
			</div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <p class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script> HALL - Wan Nur Adlina Wan Buanan
                </p>
            </div>
        </footer>

    </div>
</div>


</body>

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

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-culture',
            	message: "Welcome to <b>HALL</b> - A management booking system."

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script>
	<!-- slider -->
	<script>
		var slideIndex = 1;
		showSlides(slideIndex);
		
		function plusSlides(n) {
		  showSlides(slideIndex += n);
		}
		
		function currentSlide(n) {
		  showSlides(slideIndex = n);
		}
		
		function showSlides(n) {
		  var i;
		  var slides = document.getElementsByClassName("mySlides");
		  var dots = document.getElementsByClassName("dot");
		  if (n > slides.length) {slideIndex = 1}    
		  if (n < 1) {slideIndex = slides.length}
		  for (i = 0; i < slides.length; i++) {
		      slides[i].style.display = "none";  
		  }
		  for (i = 0; i < dots.length; i++) {
		      dots[i].className = dots[i].className.replace(" active", "");
		  }
		  slides[slideIndex-1].style.display = "block";  
		  dots[slideIndex-1].className += " active";
		}
	</script>
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

</html>