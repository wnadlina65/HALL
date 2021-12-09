<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.HallDAO" import="bean.HallBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HALL | List of Hall</title>

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
    
    <style>
		* {box-sizing: border-box;}
		
		body {
		  margin: 0;
		  font-family: Arial, Helvetica, sans-serif;
		}
		
		.topnav {
		  overflow: hidden;
		  background-color: #e9e9e9;
		}
		
		.topnav a {
		  float: left;
		  display: block;
		  color: black;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		  font-size: 17px;
		}
		
		.topnav a:hover {
		  background-color: #ddd;
		  color: black;
		}
		
		.topnav a.active {
		  background-color: #2196F3;
		  color: white;
		}
		
		.topnav .search-container {
		  float: right;
		}
		
		.topnav input[type=text] {
		  padding: 6px;
		  margin-top: 8px;
		  font-size: 17px;
		  border: none;
		}
		
		.topnav .search-container button {
		  float: right;
		  padding: 6px 10px;
		  margin-top: 8px;
		  margin-right: 16px;
		  background: #ddd;
		  font-size: 17px;
		  border: none;
		  cursor: pointer;
		}
		
		.topnav .search-container button:hover {
		  background: #ccc;
		}
		
		@media screen and (max-width: 600px) {
		  .topnav .search-container {
		    float: none;
		  }
		  .topnav a, .topnav input[type=text], .topnav .search-container button {
		    float: none;
		    display: block;
		    text-align: left;
		    width: 100%;
		    margin: 0;
		    padding: 14px;
		  }
		  .topnav input[type=text] {
		    border: 1px solid #ccc;  
		  }
		}
	</style>
</head>
<body>
<%
	HallDAO.setHallBean();
	request.setAttribute("hall", HallDAO.getHall((String) session.getAttribute("h_id")));
%>
<div class="wrapper">
    <div class="sidebar" data-color="white" data-image="assets/img/sidebar-5.jpg">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->

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
                      <li><a href="stafflist.jsp">List of Staff</a></li>
                      <li><a href="addstaff.jsp">Add Staff</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-culture"></i>
                       	<p>Hall<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      <li><a href="hall.jsp">List of Hall</a></li>
                      <li><a href="addhall.jsp">Add Hall</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-users"></i>
                       	<p>Customer<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      	<li><a href="customer.jsp">List of Customer</a></li>
                      	<li class="divider"></li>
                   	   	<li><a href="addcustomer.jsp">Add Customer</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="pe-7s-note2"></i>
                       	<p>Booking<b class="caret"></b></p>
				  	</a>
                    <ul class="dropdown-menu">
                      	<li><a href="bookinglist.jsp">Booking List</a></li>
                      	<li class="divider"></li>
                   	   	<li><a href="booking.jsp">Add Booking</a></li>
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
                    <a class="navbar-brand" href="#">List of Hall</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										<center>
											<%
												String name = (String) session.getAttribute("s_FName");
												String no = (String) session.getAttribute("sno");
											%>
											Welcome <%=name%>
										</center> 
										<b class="caret"></b>
									</p>
							  </a>
                              <ul class="dropdown-menu">
                                <li><a href="login.jsp">Logout</a></li>
                              </ul>
                        </li>
                        <li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav>

		<!-- <div class="search-container">
		    <form action="#">
		      <input type="text" placeholder="Search.." name="search">
		      <button type="submit"><i class="fa fa-search"></i></button>
		    </form>
		 </div> -->
		 
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>No</th>
                                    	<th>Hall Name</th>
                                    	<th>Status</th>
                                    	<th>Price (RM)</th>
                                    	<th>Hall Type</th>
                                    	<th>Action</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${HallDAO.getHallBean()}" var="hall">
											<tr>
												<td>${hall.h_id}</td>
												<td>${hall.h_name}</td>
												<td>${hall.h_status}</td>
												<td>${hall.h_price}</td>
												<td>${hall.ht_id}</td>
												<td>
													<a href="edithall.jsp?h_id=${hall.h_id}">Update</a>
													<a href="edithall1.jsp?h_id=${hall.h_id}">Delete</a>
												</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
							</div>
                        </div>
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
<script>
		if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
	        console.log('reload');
	    } 
		else if(performance.navigation.type == performance.navigation.TYPE_NAVIGATE){
	        console.log('navigate');
	        var id = '<%= session.getAttribute("msgid") %>';
	        console.log('Id: ' + id);
	        
	        if(id === "1"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'success', 'message': '<div style="font-size: 20px;"><strong>Successfully Update Data !</strong> </div>'});
	        	}, 300);
	        } 
	        else if(id === "2"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'danger', 'message': '<div style="font-size: 20px;"><strong>Update Data Failed!</strong> </div>'});
	        	}, 300);
	        } 
	        else if(id === "3"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'danger', 'message': '<div style="font-size: 20px;"><strong>Delete Data Failed!</strong> </div>'});
	        	}, 300);
	        } 
	        else if(id === "4"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'success', 'message': '<div style="font-size: 20px;"><strong>Successfully Delete Data !</strong> </div>'});
	        	}, 300);
	        } 
	        else if(id === "5"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'success', 'message': '<div style="font-size: 20px;"><strong>Successfully Add Data Hall!</strong> </div>'});
	        	}, 300);
	        } 
	        else if(id === "6"){
	        	setTimeout(function() {
	        		var notify = $.notify('...');
	        		notify.update({'type': 'danger', 'message': '<div style="font-size: 20px;"><strong>Add Data Failed!</strong> </div>'});
	        	}, 300);
	        } 
	        else {
	            console.log('navigate w/o param');
	        }
	    } 
	    else {
	        console.log('not login yet');
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


</html>