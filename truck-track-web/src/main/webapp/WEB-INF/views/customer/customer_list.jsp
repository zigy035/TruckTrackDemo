<%@ include file="/WEB-INF/templates/include.jsp" %>

<!-- <html> -->
<!-- <head> -->
<!-- 	<META http-equiv="Content-Type" content="text/html;charset=UTF-8"> -->
<%-- 	<link rel="stylesheet" type="text/css" href="<c:url value="/public/css/app.css"/>"> --%>
<!-- 	<title>Customer List</title> -->
<!-- </head>	 -->
<!-- <body> -->
	<a href="<c:url value="/person/new"/>">Create new customer</a>
	<h1>Customer List</h1>
	<table class="container">
		<tr>
			<th>Name</th>
			<th>Postcode</th>
			<th>Address</th>
		</tr>
		<c:forEach var="customer" items="${customers}">
		<tr>
			<td>${customer.name}</td>
			<td>${customer.postcode}</td>
			<td>${customer.address}</td>
		</tr>
		</c:forEach>
	</table>
<!-- </body> -->
<!-- </html> -->