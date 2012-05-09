<%@page import="com.topriddy.seamphiex.ViewController"%>
<%@page import="com.topriddy.seamphiex.portlet.admin.AdminPortletState"%>
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

<script type="text/javascript" src="/bootstrap/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	function switchTab(id) {
		$('.nav li').removeClass("active");
		$("#" + id).addClass("active");
	}
</script>
</head>
<body>
	<%
		AdminPortletState adminPortletState = AdminPortletState.getInstance(request, response);
	%>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">App+</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="/AdminPortlet?action=switchTabs&tab=1">Manage Projects</a></li>
						<li><a href="/AdminPortlet?action=switchTabs&tab=2">Manage Supervisors</a></li>
						<li><a href="/AdminPortlet?action=switchTabs&tab=3">Manage Students</a></li>
						<li class="pull-right"><a href="/signOut"> Sign Out</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="container">
		<%
			if (adminPortletState.getCurrentView() == AdminPortletState.DEFAULT_VIEW
				|| adminPortletState.getCurrentView() == AdminPortletState.MANAGE_PROJECT_VIEW) {
		%>
			<jsp:include page="default.jsp" flush="false" />
		<%
			} else if(adminPortletState.getCurrentView() == AdminPortletState.MANAGE_STUDENTS_VIEW){
		%>
			<jsp:include page="manageStudents.jsp" flush="false" />
		<%}else if(adminPortletState.getCurrentView() == AdminPortletState.MANAGE_SUPERVISORS_VIEW){
		%>
			<jsp:include page="manageSupervisors.jsp" flush="false" />
		<%} %>
	</div>
</body>
</html>
