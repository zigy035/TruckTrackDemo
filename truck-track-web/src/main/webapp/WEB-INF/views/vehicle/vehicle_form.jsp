<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
	$(document).ready(function() {
		$(document).ready(function() {
			$("#deadlineDate").datepicker({
				showOn: "button",
				buttonImage: "${pageContext.request.contextPath}/styles/images/calendar1.gif",
				buttonImageOnly: true,
				buttonText: "Select date",
				changeMonth: true,
			    changeYear: true,
			    dateFormat: "dd/mm/yy"		    
		    });
		});
		
		addressFieldsAutocomplete('refCountryCodeFrom', 'postCodeFrom', 'cityFrom');
		addressFieldsAutocomplete('refCountryCodeTo', 'postCodeTo', 'cityTo');
	});
	
	function addressFieldsAutocomplete(countryCodeId, postCodeId, cityId) {
		
	    $("#"+cityId).autocomplete({
	    	minLength: 2,
	        delay: 500,
	        //define callback to format results
	        source: function (request, response) {
	            $.getJSON("${pageContext.request.contextPath}/vehicle/getCities", request, function(result) {
	                response($.map(result, function(item) {
	                    return {
	                        id: item.id,
	                        name: item.name,
	                        postcode: item.postcode,
	                        label: item.name + "(" + item.postcode + ")",
	                        countryCode: item.refCountryCode
	                    }
	                }));
	            });
	        },
	        focus: function () {
	            // prevent value inserted on focus
	            return false;
	        },
	        select: function (event, ui) {
	        	if (ui.item) {
	                event.preventDefault();
	                
	                $("#"+cityId).val(ui.item.name);
	                $("#"+postCodeId).val(ui.item.postcode);
	                $("#"+countryCodeId + " [value=" + ui.item.countryCode + "]").prop("selected", true);
	                
	                return false;
	            }
	        }
	    });
    }

</script>


<c:url var="listVehicleURL" value="/vehicle/list" />
<a href="${listVehicleURL}">Vehicle List</a>

<h1>Vehicle Form</h1>
<div class="form_content">
	<form:form commandName="vehicleFormBean" action="${newVehicleURL}" method="post">
		<p>
			<form:label path="deadline"><spring:message code="vehicle.deadline"/></form:label>
			<form:input id="deadlineDate" path="deadline" cssErrorClass="error"/>
			<form:errors path="deadline"/>
			<br/>
		</p>
		<p>
			<strong>FROM:</strong>
			
			<form:label path="refCountryCodeFrom"><spring:message code="vehicle.countryfrom"/></form:label>
			<form:select path="refCountryCodeFrom">
				<form:option value=""><spring:message code="please.select.country" /></form:option>    							
				<c:forEach items="${countryCodes}" var="countryCode">
					<c:choose>
						<c:when test="${countryCode eq vehicleFormBean.refCountryCodeFrom}">
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
			<form:errors path="refCountryCodeFrom" cssClass="error"/><br/>
	
			<form:label path="cityFrom"><spring:message code="vehicle.cityfrom"/></form:label>
			<form:input path="cityFrom" cssErrorClass="error" autocomplete="off" />
			<form:errors path="cityFrom"/>
	
			<form:label path="postCodeFrom"><spring:message code="vehicle.postcodefrom"/></form:label>
			<form:input path="postCodeFrom" cssErrorClass="error" autocomplete="off" />
			<form:errors path="postCodeFrom"/>
			
		</p>
		<p>
			<strong>TO:</strong>
			
			<form:label path="refCountryCodeTo"><spring:message code="vehicle.countryto"/></form:label>
			<form:select path="refCountryCodeTo">
				<form:option value=""><spring:message code="please.select.country" /></form:option>    							
				<c:forEach items="${countryCodes}" var="countryCode">
					<c:choose>
						<c:when test="${countryCode eq vehicleFormBean.refCountryCodeTo}">
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
			<form:errors path="refCountryCodeTo" cssClass="error"/><br/>
			
			<form:label path="cityTo"><spring:message code="vehicle.cityto"/></form:label>
			<form:input path="cityTo" cssErrorClass="error" />
			<form:errors path="cityTo"/>
	
			<form:label path="postCodeTo"><spring:message code="vehicle.postcodeto"/></form:label>
			<form:input path="postCodeTo" cssErrorClass="error" />
			<form:errors path="postCodeTo"/>
			
		</p>
		<p>
			<form:label path="dimLength"><spring:message code="vehicle.length"/></form:label>
			<form:input path="dimLength" cssErrorClass="error" />
			<form:errors path="dimLength"/>
			<br/>
		</p>
		<p>
			<form:label path="dimWeight"><spring:message code="vehicle.weight"/></form:label>
			<form:input path="dimWeight" cssErrorClass="error" />
			<form:errors path="dimWeight"/>
			<br/>
		</p>
		<p>
			<form:label path="type"><spring:message code="vehicle.type"/></form:label>
			<form:input path="type" cssErrorClass="error" />
			<form:errors path="type"/><br/>
		</p>
		
		<input type="submit" value="<spring:message code="vehicle.save"/>"/>
	</form:form>
</div>
	