<%@ include file="/WEB-INF/templates/include.jsp" %>

<!-- <html> -->
<!-- <head> -->
<!-- 	<META http-equiv="Content-Type" content="text/html;charset=UTF-8"> -->
<%-- 	<link rel="stylesheet" type="text/css" href="<c:url value="/public/css/app.css"/>"> --%>
<!-- 	<title>Project List</title> -->
<!-- </head>	 -->
<!-- <body> -->
	<a href="<c:url value="/vehicle/new"/>">Create new vehicle</a>
	<h1>Vehicle List</h1>
	<table class="container">
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach var="vehicle" items="${vehicles}">
		<tr>
			<td>${vehicle.name}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>