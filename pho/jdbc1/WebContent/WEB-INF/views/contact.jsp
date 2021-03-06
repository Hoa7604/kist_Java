<%@page import="td.kits3.livedinner.dao.ContactDAO"%>
<%@page import="tp.kits3.livedinner.io.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String contextPath = request.getContextPath();
    	//System.out.println(contextPath);
    	ContactDAO dao = new ContactDAO();
    	//Contact contact = new Contact();
    	List<Contact> list = (List<Contact>)request.getAttribute("ContactList");
    	ServletContext cxv = request.getServletContext();
    	//contact = (Contact) cxv.getAttribute("ContactFind");
    	List<Contact> listCT = (List<Contact>) cxv.getAttribute("ContactFind");
    	System.out.println(listCT);
    %>
<!DOCTYPE html>
<html lang="en"><!-- Basic -->
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Site Metas -->
    <title>Live Dinner Restaurant</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="<%=contextPath %>/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href=<%=contextPath %>"images/apple-touch-icon.png">

	<!-- Site CSS -->
    <link rel="stylesheet" href="<%=contextPath %>/css/style.css">    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=contextPath %>/css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<!-- Start header -->
	<header style = "position: fixed;">
		<nav>
			<div class="container">
				<a href="index.html">
					<img src=" <%=contextPath %>/images/logo.png" alt="" />
				</a>
				<button type="button" data-toggle="collapse" data-target="#navbars-rs-food" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
				  <span>Search</span>
				</button>
				<div id="navbars-rs-food">
					<ul>
						<li><a class="active" href="/jdbc1/">Home</a></li>
						<li><a href="#">Menu</a></li>
						<li><a href="#">About</a></li>
						<li >
							<a href="#" id="dropdown-a" onclick="show('subPage')" data-toggle="dropdown">Pages</a><br>
							<div id="subPage" class="drop-menu" aria-labelledby="dropdown-a">
								<a href="reservation.html">Reservation</a>
								<a href="stuff.html">Stuff</a>
								<a href="gallery.html">Gallery</a>
							</div>
						</li>
						<li>
							<a href="#" id="dropdown-a" onclick="show('subBlog')" data-toggle="dropdown">Blog</a>
							<div id = "subBlog" class="drop-menu" aria-labelledby="dropdown-a">
								<a href="blog.html">blog</a>
								<a href="blog-details.html">Blog Single</a>
							</div>
						</li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->

	
	<!-- Start Contact -->
	<div class="contact-box-start">
		<div class="container">
			<div class="row">
				<div class="title-box">
					<div class="wrap-title">
						<h2>Contact</h2>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="wrap-form">
					<form id="contactForm" action="<%=request.getContextPath() %>/contact/add" method="post">
						<div class="wrap-sub-form">
							<div class="wrap wrap-user">
								<div class=" box user-box">
									Usename: 
									<input type="text" id="name" name="name" placeholder="Your Name" required data-error="Please enter your name">
									<div ></div>
								</div>                                 
							</div>
							<div class="wrap  wrap-phone">
								PhoneNumber: 
								<div class="box phone-box">
									<input type="phone" id="priphone" name="priphone" placeholder="Your Phone" required data-error="Please enter your priphone">
									<input type="phone" id="subphone" name="subphone" placeholder="Your Phone" data-error="Please enter your subphone">
								</div>                                 
							</div>
							<div class="wrap  wrap-mail">
								<div class="box email-box">
									Email: 
									<input type="text" placeholder="Your Email" id="email" name="name" required data-error="Please enter your email">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-address">
								<div class="box address-box">
									Address: 
									<input type="text" placeholder="Your address" id="address" name="address" required data-error="Please enter your email">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-check">
								<div class="box check-box">
									Checkbox
									<input type="checkbox" id="unused" name="unused"  data-error="Please enter your check">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-opening">
								<div class="box opening-box">
									Opening: 
									<input type="text" placeholder="Your opening" id="opening" name="opening" required data-error="Please enter your opening">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-weekday">
								<div class="box weekday-box">
									Weekday: 
									<input type="text" placeholder="Your weekday" id="weekday" name="weekday" required data-error="Please enter your weekday">
									<div ></div>
								</div> 
							</div>
							<div class="wrap wrap-weekend">
								<div class="box weekend-box">
									<input type="text" placeholder="Your weekend" id="weekend" name="weekend" required data-error="Please enter your weekend">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-aboutus" >
								<div class="box aboutus-box"> 
									About Us: 
									<textarea id="aboutus" placeholder="Your Message" rows="4" data-error="Write your message" required></textarea>
									<div ></div>
								</div>
							</div>
							<div class="wrap  wrap-latitude">
								<div class="box latitude-box">
									Latitude: 
									<input type="text" placeholder="Your latitude" id="latitude" name="latitude" required data-error="Please enter your latitude">
									<input type="text" placeholder="Your logitude" id="logitude" name="logitude" required data-error="Please enter your logitude">
									<div ></div>
								</div> 
							</div>
							<div class="wrap  wrap-submit">
								<div class="box submit-box">
									<input type="submit" name="submit" value="Submit">
									<!-- <input type="submit" name="submit" value="Update"> -->
								</div> 
							</div>
							
						</div>            
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End Contact -->
	
	<!-- Start Contact info -->
	<div class="contact-box">
		<div class="container">
			<div class="row" >
				<div class="wrap-item">
					<i class="mof-fa fa fa-volume-control-phone" aria-hidden="true"></i>
					<div class=" wrap-common wrap-phone ">
						<h4>Phone</h4>
						<p>+ 
						<%=list.get(0).getPriphone()+
							list.get(0).getSubphone()
						%>
						</p>
					</div>
					<i class="mof-arrow fa fa-angle-double-right" aria-hidden="true"></i>
				</div>
				<div class="wrap-item">
					<i class="mof-fa fa fa-envelope" aria-hidden="true"></i>
					<div class=" wrap-common wrap-email">
						<h4>Email</h4>
						<p>
						<%=list.get(0).getEmail() %>
						</p>
					</div>
					<i class="mof-arrow fa fa-angle-double-right" aria-hidden="true"></i>
				</div>
				<div class="wrap-item">
					<i class="mof-fa fa fa-map-marker" aria-hidden="true"></i>
					<div class=" wrap-common wrap-location">
						<h4>Location</h4>
						<p>
						<%=list.get(0).getLatitude() %>
							, Lorem Street, US
						</p>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Contact info -->
	
	<!-- Start Footer -->
	<footer>
		<div >
			<div >
				<div>
					<h3>About Us</h3>
					<p>Integer cursus scelerisque ipsum id efficitur. Donec a dui fringilla, gravida lorem ac, semper magna. Aenean rhoncus ac lectus a interdum. Vivamus semper posuere dui.</p>
				</div>
				<div>
					<h3>Subscribe</h3>
					<div>
						<form>
							<input name="EMAIL" id="subs-email" placeholder="Email Address..." type="email">
							<button type="submit" >SUBSCRIBE</button>
							<div ></div>
						</form>
					</div>
					<ul>
						<li><a href="#"><i aria-hidden="true"></i></a></li>
						<li><a href="#"><i aria-hidden="true"></i></a></li>
						<li><a href="#"><i aria-hidden="true"></i></a></li>
						<li><a href="#"><i aria-hidden="true"></i></a></li>
						<li><a href="#"><i aria-hidden="true"></i></a></li>
					</ul>
				</div>
				<div>
					<h3>Contact information</h3>
					<p>Ipsum Street, Lorem Tower, MO, Columbia, 508000</p>
					<p><a href="#">+01 2000 800 9999</a></p>
					<p><a href="#"> info@admin.com</a></p>
				</div>
				<div>
					<h3>Opening hours</h3>
					<p><span>Monday: </span>Closed</p>
					<p><span>Tue-Wed :</span> 9:Am - 10PM</p>
					<p><span>Thu-Fri :</span> 9:Am - 10PM</p>
					<p><span>Sat-Sun :</span> 5:PM - 10PM</p>
				</div>
			</div>
		</div>
		
		<div>
			<div >
				<div >
					<div>
						<p>All Rights Reserved. &copy; 2018 <a href="#">Live Dinner Restaurant</a> Design By : 
					<a href="#">html design</a></p>
					</div>
				</div>
			</div>
		</div>
		
	</footer>
	<!-- End Footer -->
	
	<a href="#" id="back-to-top" title="Back to top" style="display: none;"><i aria-hidden="true"></i></a>

	<!-- ALL JS FILES -->
    <!-- ALL PLUGINS -->
    <script src="js/custom.js"></script>
</body>
</html>