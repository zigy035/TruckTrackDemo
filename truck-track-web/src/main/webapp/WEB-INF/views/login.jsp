<%@ include file="/WEB-INF/templates/include.jsp"%>

<h1><spring:message code="please.login" /></h1>
<br />

<c:if test="${error}">
	<spring:message code="login.error" />
</c:if>

<form action="../j_spring_security_check" method="post">
	<p>
		<label for="j_username"><spring:message code="username" /></label> 
		<input id="j_username" name="j_username" type="text" />
	</p>
	<p>
		<label for="j_password"><spring:message code="password" /></label> 
		<input id="j_password" name="j_password" type="password" />
	</p>
	<input type="submit" value="<spring:message code="login" />" />
</form>
