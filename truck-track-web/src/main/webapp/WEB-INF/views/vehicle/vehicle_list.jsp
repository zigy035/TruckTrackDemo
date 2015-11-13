<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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