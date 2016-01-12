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
			    url: "${pageContext.request.contextPath}/cargo/search",
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

<h4>Cargo List</h4>

<c:url var="newCargoURL" value="/cargo/new" />
<a href="${newCargoURL}">New Cargo</a>

<c:url var="searchCargoURL" value="/cargo/list" />
<div class="form_content">
	<form:form id="cargoSearchForm">
		<p>
			<label for="selConFrom">From&nbsp;&nbsp;</label>
			<util:countrySelector id="selConFrom" 
				name="countryFrom" countryCodes="${countryCodes}" selectedCode="${countryFrom}" />
			
			<label for="selConTo">To&nbsp;&nbsp;</label>
			<util:countrySelector id="selConTo" 
				name="countryTo" countryCodes="${countryCodes}" selectedCode="${countryTo}" />
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
	<c:forEach var="cargo" items="${cargos}">
	<tr>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${cargo.deadline}" /></td>
		<td>
			<span class="flag_${cargo.refCountryCodeFrom} address">${cargo.cityFrom} ${cargo.postCodeFrom}</span>
		</td>
		<td>
			<span class="flag_${cargo.refCountryCodeTo} address">${cargo.cityTo} ${cargo.postCodeTo}</span>
		</td>
<%-- 		<td>${cargo.dimLength} x ${cargo.dimWeight}</td> --%>
		<td>${cargo.vehicleType}</td>
	</tr>
	</c:forEach>	
</table>

<div class="pagincenter">
	<ul class="pagination">
		
		<c:set var="countryCondition" value="countryFrom=${countryFrom}&countryTo=${countryTo}" />
		
		<c:if test="${currentPage != 1}">
			<li class="prev">
				<a href="${searchCargoURL}?${countryCondition}&currentPage=${currentPage-1}">&laquo;</a>
			</li>
		</c:if>
 		
		<c:forEach var="i" begin="${startIndex}" end="${endIndex}" step="1">
			<li>
				<a class="${currentPage == i ? 'active' : ''}" href="${searchCargoURL}?${countryCondition}&currentPage=${i}">${i}</a>
			</li>
		</c:forEach>
		
		<c:if test="${currentPage != pageCount}">
			<li class="next">
				<a href="${searchCargoURL}?${countryCondition}&currentPage=${currentPage+1}">&raquo;</a>
			</li>
		</c:if>
		
	</ul>
</div>
