<%@ include file="/WEB-INF/templates/include.jsp" %>

<script>
	$(document).ready(function(){
		//jQuery ready is quicker than onload
		$(".stripeMe tr").mouseover(function(){$(this).addClass("over");}).mouseout(function(){$(this).removeClass("over");});
		$(".stripeMe tr:even").addClass("alt");
	});
</script>

<h4>Cargo List</h4>

<c:url var="newCargoURL" value="/cargo/new" />
<a href="${newCargoURL}">New Cargo</a>

<c:url var="searchCargoURL" value="/cargo/list" />
<div class="form_content">
	<form:form action="${searchCargoURL}" method="get">
		<p>
			
			<label for="selConFrom">From&nbsp;&nbsp;</label>
			<util:countrySelector id="selConFrom" 
				name="countryFrom" countryCodes="${countryCodes}" selectedCode="${countryFrom}" />
			
			<label for="selConTo">To&nbsp;&nbsp;</label>
			<util:countrySelector id="selConTo" 
				name="countryTo" countryCodes="${countryCodes}" selectedCode="${countryTo}" />
			
			<br/>
		</p>
		<input type="submit" value="Search" />
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
			<span class="flag_${cargo.refCountryCodeFrom} address">${cargo.addressFrom}</span>
		</td>
		<td>
			<span class="flag_${cargo.refCountryCodeTo} address">${cargo.addressTo}</span>
		</td>
<%-- 		<td>${cargo.dimLength} x ${cargo.dimWeight}</td> --%>
		<td>${cargo.type}</td>
	</tr>
	</c:forEach>	
</table>

<ul id="pagination">
	
	<c:set var="countryCondition" value="countryFrom=${countryFrom}&countryTo=${countryTo}" />
	
	<c:if test="${currentPage != 1}">
		<li class="prev">
			<a href="${searchCargoURL}?${countryCondition}&currentPage=${currentPage-1}">&lsaquo; Prev</a>
		</li>
	</c:if>
	
	<c:forEach var="i" begin="1" end="${pageCount}" step="1">
		<li class="${currentPage == i ? 'active' : ''}">
			<a href="${searchCargoURL}?${countryCondition}&currentPage=${i}">${i}</a>
		</li>
	</c:forEach>
	
	<c:if test="${currentPage != pageCount}">
		<li class="next">
			<a href="${searchCargoURL}?${countryCondition}&currentPage=${currentPage+1}">Next &rsaquo;</a>
		</li>
	</c:if>
	
</ul>
