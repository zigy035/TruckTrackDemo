<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
