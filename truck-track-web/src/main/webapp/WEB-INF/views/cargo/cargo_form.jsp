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
	            $.getJSON("${pageContext.request.contextPath}/cargo/getCities", request, function(result) {
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


<c:url var="listCargoURL" value="/cargo/list" />
<a href="${listCargoURL}">Cargo List</a>

<h1>Cargo Form</h1>
<div class="form_content">
	<form:form commandName="cargoFormBean" action="${newCargoURL}" method="post">
		<p>
			<form:label path="deadline"><spring:message code="cargo.deadline"/></form:label>
			<form:input id="deadlineDate" path="deadline" cssErrorClass="error"/>
			<form:errors path="deadline"/>
			<br/>
		</p>
		<p>
			<strong>FROM:</strong>
			
			<form:label path="refCountryCodeFrom"><spring:message code="cargo.countryfrom"/></form:label>
			<form:select path="refCountryCodeFrom">
				<form:option value=""><spring:message code="please.select.country" /></form:option>    							
				<c:forEach items="${countryCodes}" var="countryCode">
					<c:choose>
						<c:when test="${countryCode eq cargoFormBean.refCountryCodeFrom}">
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
	
			<form:label path="cityFrom"><spring:message code="cargo.cityfrom"/></form:label>
			<form:input path="cityFrom" cssErrorClass="error" autocomplete="off" />
			<form:errors path="cityFrom"/>
	
			<form:label path="postCodeFrom"><spring:message code="cargo.postcodefrom"/></form:label>
			<form:input path="postCodeFrom" cssErrorClass="error" autocomplete="off" />
			<form:errors path="postCodeFrom"/>
			
		</p>
		<p>
			<strong>TO:</strong>
			
			<form:label path="refCountryCodeTo"><spring:message code="cargo.countryto"/></form:label>
			<form:select path="refCountryCodeTo">
				<form:option value=""><spring:message code="please.select.country" /></form:option>    							
				<c:forEach items="${countryCodes}" var="countryCode">
					<c:choose>
						<c:when test="${countryCode eq cargoFormBean.refCountryCodeTo}">
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
			
			<form:label path="cityTo"><spring:message code="cargo.cityto"/></form:label>
			<form:input path="cityTo" cssErrorClass="error" />
			<form:errors path="cityTo"/>
	
			<form:label path="postCodeTo"><spring:message code="cargo.postcodeto"/></form:label>
			<form:input path="postCodeTo" cssErrorClass="error" />
			<form:errors path="postCodeTo"/>
			
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
</div>
	