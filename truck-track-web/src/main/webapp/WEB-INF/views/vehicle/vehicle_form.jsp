<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<a href="<c:url value="/vehicle/list"/>">Vehicle List</a>
<h1>Project Form</h1>
<form:form modelAttribute="vehicle" action="create" method="post">
	<p>
		<form:label path="name" cssErrorClass="error">Name</form:label><br/>
		<form:input path="name"/><form:errors path="name"/><br/>
	</p>
	<input type="submit"/>
</form:form>