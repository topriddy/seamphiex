<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>App+ - Administrator Module</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />

<style type="text/css">
body {
	padding-top: 80px;
}
</style>

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	function switchTab(id) {
		$('.nav li').removeClass("active");
		$("#" + id).addClass("active");
	}
</script>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">App+</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="#">Manage Projects</a></li>
						<li><a href="#about">Manage Supervisors</a></li>
						<li><a href="#contact">Manage Students</a></li>
						<li class="pull-right"><a href="/signOut"> Sign Out</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<h1>Welcome Administrator</h1>
</body>
</html>
