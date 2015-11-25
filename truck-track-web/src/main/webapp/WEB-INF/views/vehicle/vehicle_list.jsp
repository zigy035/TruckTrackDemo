<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>

<script>
	$(document).ready(function(){
		//jQuery ready is quicker than onload
		$(".stripeMe tr").mouseover(function(){$(this).addClass("over");}).mouseout(function(){$(this).removeClass("over");});
		$(".stripeMe tr:even").addClass("alt");
				
	    $('#btnSearch').click(function(e) {
            
            e.preventDefault();
            
            var formData = {
				'countryFrom' :  $("#selConFrom").val(),
				'countryTo' : $("#selConTo").val()
            };

			$.ajax({
			    url: "${pageContext.request.contextPath}/vehicle/search",
			    data: formData,
			    type: "GET",
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
				success: function(response) {
			     	
			     	$(".stripeMe").empty();
					$(".stripeMe").append("<tr><th>Deadline</th><th>From</th><th>To</th><th>Type</th></tr>");
					$.each(response, function(i, obj) {
						var deadlineDate = new Date(obj.deadline);
						var day = deadlineDate.getDate();
						if (day < 10) { day = "0" + day; }
						var month = deadlineDate.getMonth()+1;
						if (month < 10) { month = "0" + month; }
						var year = deadlineDate.getFullYear();
						var fmtDeadlineDate = year + '-' + month + '-' + day; 
												
						$(".stripeMe").append('<tr><td>' + fmtDeadlineDate + '</td>' + 
						'<td><span class="flag_' + obj.refCountryCodeFrom + ' address">' + obj.cityFrom + ' ' + obj.postCodeFrom + '</span></td>' +
						'<td><span class="flag_' + obj.refCountryCodeTo + ' address">' + obj.cityTo + ' ' + obj.postCodeTo + '</span></td>' + 
						'<td>' + obj.vehicleType + '</td></tr>');
								
					});

					$(".stripeMe tr").mouseover(function(){$(this).addClass("over");}).mouseout(function(){$(this).removeClass("over");});
					$(".stripeMe tr:even").addClass("alt");
				}
			});
            
	    });
		
	});
	
	
</script>

<h4>Vehicle List</h4>

<c:url var="newVehicleURL" value="/vehicle/new" />
<a href="${newVehicleURL}">New Vehicle</a>

<c:url var="searchVehicleURL" value="${pageContext.request.contextPath}/vehicle/search" />
<div class="form_content">
	<form:form id="vehicleSearchForm">
		<p>
			<label for="selConFrom">From&nbsp;&nbsp;</label>
			<util:countrySelector id="selConFrom" 
				name="countryFrom" countryCodes="${countryCodes}" selectedCode="${countryFrom}" />
			
			<label for="selConTo">To&nbsp;&nbsp;</label>
			<util:countrySelector id="selConTo" 
				name="countryTo" countryCodes="${countryCodes}" selectedCode="${countryTo}" />
			
			<br/>
		</p>
		<input id="btnSearch" type="submit" value="Search" />
	</form:form>
</div>

<table class="stripeMe sample">
	<tr>
		<th>Deadline</th>
		<th>From</th>
		<th>To</th>
<!-- 		<th>Dimensions</th> -->
		<th>Type</th>
	</tr>
	<c:forEach var="vehicle" items="${vehicles}">
	<tr>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vehicle.deadline}" /></td>
		<td>
			<span class="flag_${vehicle.refCountryCodeFrom} address">${vehicle.cityFrom} ${vehicle.postCodeFrom}</span>
		</td>
		<td>
			<span class="flag_${vehicle.refCountryCodeTo} address">${vehicle.cityTo} ${vehicle.postCodeTo}</span>
		</td>
<%-- 		<td>${vehicle.dimLength} x ${vehicle.dimWeight}</td> --%>
		<td>${vehicle.vehicleType}</td>
	</tr>
	</c:forEach>	
</table>

<ul id="pagination">
	
	<c:set var="countryCondition" value="countryFrom=${countryFrom}&countryTo=${countryTo}" />
	
	<c:if test="${currentPage != 1}">
		<li class="prev">
			<a href="${searchVehicleURL}?${countryCondition}&currentPage=${currentPage-1}">&lsaquo; Prev</a>
		</li>
	</c:if>
	
	<c:forEach var="i" begin="1" end="${pageCount}" step="1">
		<li class="${currentPage == i ? 'active' : ''}">
			<a href="${searchVehicleURL}?${countryCondition}&currentPage=${i}">${i}</a>
		</li>
	</c:forEach>
	
	<c:if test="${currentPage != pageCount}">
		<li class="next">
			<a href="${searchVehicleURL}?${countryCondition}&currentPage=${currentPage+1}">Next &rsaquo;</a>
		</li>
	</c:if>
	
</ul>
