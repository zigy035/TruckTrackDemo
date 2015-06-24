<%@ include file="/WEB-INF/templates/include.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/jquery-ui.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-1.8.3.js"></script>		
		<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-ui.js"></script>
	</head>
	<body>
		<div style="width:1200px; margin-top: -22px; margin-left: 70px;">
			<div style="background-color:#3e83c9; min-height:100px;">
				<tiles:insertAttribute name="header" />
			</div>
			<div style="background-color:#95bce2; min-height:800px;width:200px;float:left;">
			    <tiles:insertAttribute name="menu" />
			</div>
			<div style="background-color:#eeeeee; min-height:800px;width:1000px;float:left;">
				<tiles:insertAttribute name="body" />
			</div>
			<div style="background-color:#3e83c9;clear:both">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</body>
</html>
