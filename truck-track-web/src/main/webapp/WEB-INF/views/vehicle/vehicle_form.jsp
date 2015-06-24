<%@ include file="/WEB-INF/templates/include.jsp" %>

<!-- <html> -->
<!-- <head> -->
<!-- 	<META http-equiv="Content-Type" content="text/html;charset=UTF-8"> -->
<%-- 	<link rel="stylesheet" type="text/css" href="<c:url value="/public/css/app.css"/>"> --%>
<!-- 	<title>Vehicle Form</title> -->
<!-- </head>	 -->
<!-- <body> -->
	<a href="<c:url value="/vehicle/list"/>">Vehicle List</a>
	<h1>Project Form</h1>
	<form:form modelAttribute="vehicle" action="create" method="post">
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br/>
			<form:input path="name"/><form:errors path="name"/><br/>
		</p>
		<input type="submit"/>
	</form:form>
<!-- </body> -->
<!-- </html> -->