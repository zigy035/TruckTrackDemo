<%@ include file="/WEB-INF/templates/include.jsp" %>

<c:url var="registerURL" value="/register/form" />

<h1>Register Form</h1>

<div class="form_content">
	<form:form modelAttribute="customerView" action="${registerURL}" method="post">
		<p>
			<form:label path="name" cssErrorClass="error"><spring:message code="customer.name"/></form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
			<br/>
		</p>
		<p>
			<form:label path="contactPerson" cssErrorClass="error"><spring:message code="customer.contactperson"/></form:label>
			<form:input path="contactPerson"/>
			<form:errors path="contactPerson"/>
			<br/>
		</p>
		<!-- Country selector I18 ??? -->
		<form:label path="refCountryCode" cssErrorClass="error"><spring:message code="customer.country"/></form:label>
		<util:countrySelector name="refCountryCode" selectedCode="" countryCodes="${countryCodes}" id="refCountryCode" />
		<p>
			<form:label path="address" cssErrorClass="error"><spring:message code="customer.address"/></form:label>
			<form:input path="address"/>
			<form:errors path="address"/>
			<br/>
		</p>
		<p>
			<form:label path="city" cssErrorClass="error"><spring:message code="customer.city"/></form:label>
			<form:input path="city"/>
			<form:errors path="city"/>
			<br/>
		</p>
		<p>
			<form:label path="postcode" cssErrorClass="error"><spring:message code="customer.postcode"/></form:label>
			<form:input path="postcode"/>
			<form:errors path="postcode"/>
			<br/>
		</p>
		<p>
			<form:label path="telephone" cssErrorClass="error"><spring:message code="customer.telephone"/></form:label>
			<form:input path="telephone"/>
			<form:errors path="telephone"/><br/>
		</p>
		<p>
			<form:label path="email" cssErrorClass="error"><spring:message code="customer.email"/></form:label>
			<form:input path="email"/>
			<form:errors path="email"/><br/>
		</p>
		<p>
			<form:label path="memo" cssErrorClass="error"><spring:message code="customer.memo"/></form:label>
			<form:textarea path="memo"/>
			<form:errors path="memo"/><br/>
		</p>
		
		<input type="submit" value="<spring:message code="customer.register"/>"/>
	</form:form>
</div>