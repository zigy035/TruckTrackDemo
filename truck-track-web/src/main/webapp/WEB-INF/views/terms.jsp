<%@ include file="/WEB-INF/templates/include.jsp"%>

<p>
	<label><spring:message code="terms.conditions" /></label> 
</p>

<c:url var="acceptURL" value="/auth/terms" />

<form:form action="${acceptURL}" modelAttribute="termsAcceptanceView" method="post">
	<form:hidden path="username" />
	<input type="submit" value="<spring:message code="terms.accept" />" />
</form:form>