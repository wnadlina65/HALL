<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.HallDAO" import="bean.HallBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HALL | Hall</title>

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
		body {
		  font-family: Arial;
		}
		
		input[type=text], select {
		  width: 100%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  display: block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		input[type=tel], select {
		  width: 100%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  display: block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		input[type=submit]{
		  width: 10%;
		  background-color: #00bfff;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		
		input[type=delete] {
		  width: 10%;
		  background-color: #FF3333;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		
		input[type=submit]:hover {
		  background-color: #00bfff;
		}
		
		div.container {
		  border-radius: 2px;
		  background-color: #f2f2f2;
		  padding: 20px;
		}
	</style>
</head>
<body>
<%
	String id = request.getParameter("h_id");
	HallDAO.setHallBean();
	request.setAttribute("hall", HallDAO.getHall(id));
%>
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

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Hall Details</h4>
                            </div>
                            <div class="content">
                                <form method="post" action="UpdateHall">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Hall Name</label>
                                                <input type="text" class="form-control" name="h_name" placeholder="Enter Hall Name" value="${hall.h_name}" required>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Status</label>
                                                <select name="h_status" required>
											      <option value="${hall.h_status}">Default : ${hall.h_status}</option>
											      <option value="Unoccupied">Unoccupied</option>
											      <option value="Occupied">Occupied</option>
											    </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Price (RM)</label>
                                                <input type="text" class="form-control" name="h_price" placeholder="Enter Price" value="${hall.h_price}" required>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Hall Type</label>
                                                <select name="ht_id" required>
											      <option value="${hall.ht_id}">Default : ${hall.ht_id}</option>
											      <option value="1">Ballroom</option>
											      <option value="2">Dining Hall</option>
											      <option value="3">Meeting Hall</option>
											      <option Value="4">Wedding Hall</option>
											      <option value="5">Exhibition Hall</option>
											    </select>
                                            </div>
                                        </div>
                                    </div>

                    				<div>
								  		<input type="hidden" name="h_id" value="${hall.h_id}" hidden>
								  		<input type="submit" id="udpate" name="save" value="Update" onclick="return myFunction()" class="btn btn-info btn-fill pull-left">&nbsp;
								  	</div>
                                    <div class="clearfix"></div>
                                </form>
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
	function myFunction() {
	  var txt = '<%= session.getAttribute("msgid") %>';
	  var r = confirm("Are you sure to update this data?");
	  if (r == true) {
	    txt = "Update";
	  } 
	  else {
	    txt = "Update";
	  }
	  document.getElementById("update").innerHTML = txt;
	  return r;
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