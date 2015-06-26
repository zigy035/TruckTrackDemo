<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
	$(document).ready(function() {

		$('#deadlineDate').datepicker();

	});
</script>

<c:url var="listCargoURL" value="/cargo/list" />
<a href="${listCargoURL}">Cargo List</a>

<h1>Cargo Form</h1>
<form:form modelAttribute="cargoView" action="${newCargoURL}" method="post">
	<p>
		<form:label path="deadline"><spring:message code="cargo.deadline"/></form:label>
		<form:input id="deadlineDate" path="deadline" cssErrorClass="error"/>
		<form:errors path="deadline"/>
		<br/>
	</p>
	<p>
		<form:label path="addressFrom"><spring:message code="cargo.addressfrom"/></form:label>
		<form:input path="addressFrom" cssErrorClass="error" />
		<form:errors path="addressFrom"/>
		<br/>
	</p>
	<p>
		<form:label path="addressTo"><spring:message code="cargo.addressto"/></form:label>
		<form:input path="addressTo" cssErrorClass="error" />
		<form:errors path="addressTo"/>
		<br/>
	</p>
	<p>
		<form:label path="dimLength"><spring:message code="cargo.length"/></form:label>
		<form:input path="dimLength" cssErrorClass="error" />
		<form:errors path="dimLength"/>
		<br/>
	</p>
	<p>
		<form:label path="dimWeight"><spring:message code="cargo.weight"/></form:label>
		<form:input path="dimWeight" cssErrorClass="error" />
		<form:errors path="dimWeight"/>
		<br/>
	</p>
	<p>
		<form:label path="type"><spring:message code="cargo.type"/></form:label>
		<form:input path="type" cssErrorClass="error" />
		<form:errors path="type"/><br/>
	</p>
	
	<input type="submit" value="<spring:message code="cargo.save"/>"/>
</form:form>
	