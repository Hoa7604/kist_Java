<%@page import="tp.kits3.livedinner.io.Book"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String contextPath = request.getContextPath();
    	List<Book> listbook = (List<Book>) request.getAttribute("BookList");
    	//String path = (String) request.getAttribute("path");
    	
    	
    	//ServletContext svc = request.getServletContext();
    	//svc.getAttribute("path");
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
	<header style = "position: initial;">
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
						<li><a class="active" href="<%=contextPath %>/menu/list">Home</a></li>
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
	
	<!-- Start All Pages -->
<%-- 	<%for( int i = 0; i < list.size(); i++){%>
		<div >
			<div >
				<div >
					<div >
						<p>name: <%=list.get(i).getConame() %></p>
						<h1>Email: <%=list.get(i).getEmail() %></h1>
					</div>
				</div>
			</div>
		</div>
	<% }%> --%>

	<!-- End All Pages -->
	
	<!-- Start Contact -->
	<div></div>
	<div>
		<div >
			<div >
				<div >
					<div >
						<h2>Contact</h2>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting</p>
					</div>
				</div>
			</div>
			<div >
				<div >
					<form id="contactForm">
						<div >
							<div >
								<div >
									<input type="text" id="name" name="name" placeholder="" required data-error="Please enter your name">
									<div ></div>
								</div>                                 
							</div>
							<div >
								<div >
									<input type="text" placeholder="" id="email" name="name" required data-error="Please enter your email">
									<div ></div>
								</div> 
							</div>
							<div >
								<div >
									<select id="guest" required data-error="Please Select Person">
									  <option disabled selected>Please Select Person*</option>
									  <option value="1">1</option>
									  <option value="2">2</option>
									  <option value="3">3</option>
									  <option value="4">4</option>
									  <option value="5">5</option>
									</select>
									<div ></div>
								</div> 
							</div>
							<div >
								<div > 
									<textarea id="message" placeholder="Your Message" rows="4" data-error="Write your message" required></textarea>
									<div ></div>
								</div>
								<div >
									<button id="submit" type="submit">Send Message</button>
									<div id="msgSubmit"></div> 
									<div ></div> 
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
	<div>
		<div >
			<div >
				<div>
					<i></i>
					<div>
						<h4>Phone</h4>
						<p>
							+01 123-456-4590
						</p>
					</div>
				</div>
				<div>
					<i></i>
					<div>
						<h4>Email</h4>
						<p>
							yourmail@gmail.com
						</p>
					</div>
				</div>
				<div>
					<i></i>
					<div>
						<h4>Location</h4>
						<p>
							800, Lorem Street, US
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