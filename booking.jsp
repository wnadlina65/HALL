<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="dao.CustDAO" import="bean.CustBean"%>
	<%@page import="dao.HallDAO" import="bean.HallBean"%>
	<%@page import="dao.BookDAO" import="bean.BookBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HALL | Booking</title>

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
	
	String id = request.getParameter("bk_id");
	BookDAO.setBookBean();
	request.setAttribute("booking", BookDAO.getBook(id));
	
	//String c_id = request.getParameter("c_id");
	CustDAO.setCustBean();
	request.setAttribute("customer", CustDAO.getCustBean());
	
	
	//String h_id = request.getParameter("h_id");
	HallDAO.setHallBean();
	request.setAttribute("hall", HallDAO.getHallBean());
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

		<!-- Booking form -->
			<div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Add Booking Details</h4>
                            </div>
                            <div class="content">
                                <form method="post" action="AddBooking">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Event Name</label>
                                                <input type="text" class="form-control" name="bk_name" placeholder="Enter Event Name" required>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>Start Date/Time</label>
	       										<input type="datetime-local" style="text-transform:uppercase" class="form-control form-control-user" name="bk_strdate" placeholder="Start Date of booking" required></br>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>End Date/Time</label>
	       										<input type="datetime-local" style="text-transform:uppercase" class="form-control form-control-user" name="bk_enddate" placeholder="End Date of booking" required></br>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>No. of Pax</label>
                                                <input type="number" class="form-control" name="bk_pax" placeholder="Enter No. of Pax" required>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label>Total Price (RM)</label>
                                                <input type="text" class="form-control" name="bk_totprice" placeholder="Enter Price (RM)" required>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Customer's Name</label>
                                                <select name="c_id">
                                                	<option value="NONE">Choose Customer's Name</option>
												    <c:forEach items="${customer}" var="cust">
												    	<option value="${cust.c_id}">${cust.c_name}</option>
										      		</c:forEach>
											    </select>
                                            </div>
                                        </div>
                                    </div>
                                                                        
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Hall Name</label>
                                                <select name="h_id">
											      <option value="NONE">Choose Hall Name</option>
												  <c:forEach items="${hall}" var="hall">
											  		 <option value="${hall.h_id}">${hall.h_name}</option>
										      	  </c:forEach>
											    </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div>
								  		<input type="submit" name="save" value="Submit">
								  	</div>
								    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    
				</div>
            </div>
        </div>
		<!-- End of booking form -->
		
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
	<!-- Calculate total price booking hall -->
	<script>
        function calculateAmount(val) {
            var tot_price = val * 100;
            /*display the result*/
            var divobj = document.getElementById('tot_amount');
            divobj.value = tot_price;
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