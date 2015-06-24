<%@ include file="/WEB-INF/templates/include.jsp" %>

<html>
<head>
	<META�http-equiv="Content-Type"�content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/public/css/app.css"/>">
	<title>Customer Form</title>
</head>	
<body>
	<a href="<c:url value="/customer/list"/>">Customer List</a>
	<h1>Person Form</h1>
	<form:form modelAttribute="customer" action="create" method="post">
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br/>
			<form:input path="name"/><form:errors path="name"/><br/>
		</p>
		<p>
			<form:label path="postcode" cssErrorClass="error">Postcode</form:label><br/>
			<form:input path="postcode"/><form:errors path="postcode"/><br/>
		</p>
		<p>
			<form:label path="address" cssErrorClass="error">Address</form:label><br/>
			<form:input path="address"/><form:errors path="address"/><br/>
		</p>
		<input type="submit"/>
	</form:form>
</body>
</html>