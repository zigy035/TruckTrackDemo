<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<p>
	<label><spring:message code="terms.conditions" /></label> 
</p>

<c:url var="acceptURL" value="/auth/terms" />

<form:form action="${acceptURL}" modelAttribute="termsAcceptanceView" method="post">
	<form:hidden path="username" />
	<input type="submit" value="<spring:message code="terms.accept" />" />
</form:form>