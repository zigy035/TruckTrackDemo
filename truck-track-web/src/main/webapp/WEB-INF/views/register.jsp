<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>

<c:url var="registerURL" value="/register/form" />

<h1>Register Form</h1>

<div class="form_content">
	<form:form commandName="registerFormBean" action="${registerURL}" method="post">
		<p>
			<form:label path="name"><spring:message code="customer.name"/></form:label>
			<form:input path="name"/>
			<form:errors path="name" cssErrorClass="error" />
			<br/>
		</p>
		<p>
			<form:label path="contactPerson"><spring:message code="customer.contactperson"/></form:label>
			<form:input path="contactPerson"/>
			<form:errors path="contactPerson" cssErrorClass="error"/>
			<br/>
		</p>
		<p>
			<form:label path="refCountryCode"><spring:message code="customer.country"/></form:label>
			<form:select path="refCountryCode">
				<form:option value=""><spring:message code="please.select.country" /></form:option>    							
				<c:forEach items="${countryCodes}" var="countryCode">
					<c:choose>
						<c:when test="${countryCode eq registerFormBean.refCountryCode}">
							<option value="${countryCode}" selected="selected">
								<spring:message code="country.name.${fn:toLowerCase(countryCode)}" />
							</option>
						</c:when>
						<c:otherwise>
							<option value="${countryCode}">
								<spring:message code="country.name.${fn:toLowerCase(countryCode)}" />
							</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
			<form:errors path="refCountryCode" cssClass="error"/><br/>
		</p>
		<p>
			<form:label path="address"><spring:message code="customer.address"/></form:label>
			<form:input path="address"/>
			<form:errors path="address" cssErrorClass="error"/>
			<br/>
		</p>
		<p>
			<form:label path="city"><spring:message code="customer.city"/></form:label>
			<form:input path="city"/>
			<form:errors path="city" cssErrorClass="error"/>
			<br/>
		</p>
		<p>
			<form:label path="postcode"><spring:message code="customer.postcode"/></form:label>
			<form:input path="postcode"/>
			<form:errors path="postcode" cssErrorClass="error"/>
			<br/>
		</p>
		<p>
			<form:label path="telephone"><spring:message code="customer.telephone"/></form:label>
			<form:input path="telephone"/>
			<form:errors path="telephone" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="email"><spring:message code="customer.email"/></form:label>
			<form:input path="email"/>
			<form:errors path="email" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="memo"><spring:message code="customer.memo"/></form:label>
			<form:textarea path="memo"/>
		</p>
		
		<%-- 
		--%>
		<p>
			<form:label path="firstName"><spring:message code="customer.firstname"/></form:label>
			<form:input path="firstName"/>
			<form:errors path="firstName" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="lastName"><spring:message code="customer.lastname"/></form:label>
			<form:input path="lastName"/>
			<form:errors path="lastName" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="username"><spring:message code="customer.username"/></form:label>
			<form:input path="username"/>
			<form:errors path="username" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="password"><spring:message code="customer.password"/></form:label>
			<form:password path="password" showPassword="true"/>
			<form:errors path="password" cssErrorClass="error"/><br/>
		</p>
		<p>
			<form:label path="confirmPassword"><spring:message code="customer.confirm.password"/></form:label>
			<form:password path="confirmPassword" showPassword="true"/>
			<form:errors path="confirmPassword" cssErrorClass="error"/><br/>
		</p> 
		<div id="terms_conditions">
			<form:checkbox id="termsConditionsChb" path="termsConditions"/>
			<form:label path="termsConditions" for="termsConditionsChb"><spring:message code="customer.terms.conditions"/></form:label><br/>
			<form:errors path="termsConditions" cssErrorClass="error"/>
		</div>
		
		<input type="submit" value="<spring:message code="customer.register"/>"/>
	</form:form>
</div>