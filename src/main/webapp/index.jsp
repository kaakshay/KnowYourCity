<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Agency - Start Bootstrap Theme</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/agency.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container">
			<div class="intro-text">
				<div class="intro-heading">Welcome to Know-Your-City</div>
				<div class="intro-lead-in">
					We provide you with essential information regarding different location in a city</br>to aid you in your house hunt.
				</div>
				<a href="#services" class="page-scroll btn btn-xl">Get Started</a>
			</div>
		</div>
	</header>

	<!-- Services Section -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Choose the state and the city to
						get started!</h2>
					<h3 class="section-subheading text-muted">Good Luck!</h3>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4" style="width: 50%">
					<!-- <span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
					</span> -->
					<h4 class="service-heading">State</h4>
					<form>
						<select class="btn btn-info" name="state" id="states">
						</select>
					</form>
				</div>
				<div class="col-md-4" style="width: 50%">
					<!-- <span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-laptop fa-stack-1x fa-inverse"></i>
					</span> -->
					<h4 class="service-heading">City</h4>
					<form>
						<select class="btn btn-info" name="city" id="cities">
						<option value="">City</option>
						</select>
					</form>
				</div>
			</div>
			</br>
			</br>
			</br>
			<div class="row text-center">
				<form>
					<input class="page-scroll btn btn-xl" type="button" id="go" value="Go">
					
				</form>
			</div>
		</div>
	</section>




	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Know Your City 2015</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline social-buttons">
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>


	<!-- Portfolio Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<!-- Project Details Go Here -->
							<h2 id="cityDetailsHeader"></h2>
							<p class="item-intro text-muted">Lorem ipsum dolor sit amet
								consectetur.</p>
							<img class="img-responsive img-centered"
								src="resources/img/portfolio/roundicons-free.png" alt="">
							<p>Use this area to describe your project. Lorem ipsum dolor
								sit amet, consectetur adipisicing elit. Est blanditiis dolorem
								culpa incidunt minus dignissimos deserunt repellat aperiam quasi
								sunt officia expedita beatae cupiditate, maiores repudiandae,
								nostrum, reiciendis facere nemo!</p>
							<p>
								<strong>Want these icons in this portfolio item sample?</strong>You
								can download 60 of them for free, courtesy of <a
									href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">RoundIcons.com</a>,
								or you can purchase the 1500 icon set <a
									href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">here</a>.
							</p>
							<ul class="list-inline">
								<li>Date: July 2014</li>
								<li>Client: Round Icons</li>
								<li>Category: Graphic Design</li>
							</ul>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close Project
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="resources/js/classie.js"></script>
	<script src="resources/js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="resources/js/jqBootstrapValidation.js"></script>
	<script src="resources/js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/js/agency.js"></script>
	
	<c:url var="statesURL" value="/states" />
	<script>
	$(document).ready(
			function() {
				$.getJSON('${statesURL}', {
					ajax : 'true'
				}, function(data) {
					console.log(data)
					var html = '<option value="">State</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i] + '">'
								+ data[i] + '</option>';
					}
					html += '</option>';
		                        //now that we have our options, give them to our select
					$('#states').html(html);
				});
			});
	</script>
	
<c:url var="findStateCitiesURL" value="/cities" />
<c:url var="getZipcodesURL" value="/getZipcodes" />
 
<script type="text/javascript">
$(document).ready(function() { 
	$('#states').change(
		function() {
			$.getJSON('${findStateCitiesURL}', {
				stateName : $(this).val(),
				ajax : 'true'
			}, function(data) {
				var html = '<option value="">City</option>';
				var len = data.length;
				console.log(data);
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i] + '">'
							+ data[i]+ '</option>';
				}
				html += '</option>';
 
				$('#cities').html(html);
			});
		});
});
$("#go").click(function(){
	$.getJSON('${getZipcodesURL}', {
		stateName : $('#states').val(),
		cityName : $('#cities').val(),
		ajax : 'true'
	}, function(data) {
		console.log(data);
		console.log(data['stateName']);
		console.log(data['cityName']);
		$('#cityDetailsHeader').html(data['cityName'] + ', ' +data['stateName']);
		$('#portfolioModal1').modal('show');
		/* var html = '<option value="">City</option>';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option value="' + data[i] + '">'
					+ data[i]+ '</option>';
		}
		html += '</option>';

		$('#cities').html(html); */
	});
});
</script>
</body>

</html>
