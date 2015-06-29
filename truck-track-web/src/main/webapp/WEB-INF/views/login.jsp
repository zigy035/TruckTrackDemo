<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form action="../j_spring_security_check" method="post">
	<div class="sidebar">
		<c:if test="${error}">
			<p><spring:message code="login.error" /></p>
		</c:if>
		<h3><spring:message code="please.login" /></h3>
		<ul>
			<li>
				<label for="j_username"><spring:message code="username" /></label> 
				<input id="j_username" name="j_username" type="text" />
			</li>
			<li>
				<label for="j_password"><spring:message code="password" /></label> 
				<input id="j_password" name="j_password" type="password" />
			</li>
			<li><input type="submit" value="<spring:message code="login" />" /></li>
		</ul>
	</div>	
</form>
