<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.ui-icon ui-icon-closethick {
		background-image: url("images/calendar1.gif") !important;
	}
</style>

<script type="text/javascript">
	
	function openEditDialog() {
		$("#editDialog").dialog({
			resizable: false,
			autoOpen: false,
			height:140,
			modal: true
		});
	}
	
	function openDeleteDialog() {
 		$("#deleteDialog").fancybox({
			'width' : 300, 
			'height' : 300, 
			'modal'	: true,
			'isOpen' : true
		});
 
 /*
		$.fancybox({
			width : 300, 
			height : 300,
			modal: true,
			type: 'inline',
	        content: '#deleteDialog',
			helpers : {
		        overlay : {
		            css : {
		                'background' : 'rgba(58, 42, 45, 0.3)'
		            }
		        }
		    }
	    });
 */
		
	}
	
	function closeDeleteDialog() {
		$("#deleteDialog").fancybox({
			'width' : 300, 
			'height' : 300, 
			'modal'	: true,
			'isOpen' : false
		});
	}

	function fillDataTable(response) {
		if (response != undefined && response.length > 0) {
	     	$(".stripeMe").empty();
			$(".stripeMe").append("<tr><th>City</th><th>Postcode</th><th>Action</th></tr>");
			$.each(response, function(i, obj) {												
				$(".stripeMe").append('<tr><td class="city">' + obj.name + '</td><td class="postcode">' + obj.postcode + 
						'</td><td><a class="openerEdit" id="' + obj.id + '" href="#">Edit</a>' + 
						'<a href="#" class="openerDelete" id="' + obj.id + '" href="#">Delete</a></td></tr>');
			});
	
			$(".stripeMe tr").mouseover(function(){$(this).addClass("over");}).mouseout(function(){$(this).removeClass("over");});
			$(".stripeMe tr:even").addClass("alt");
			$(".stripeMe").show();
	    }
	    else {
	    	$(".stripeMe").hide();
	    }
	}
	
	$(document).ready(function() {
		$(".stripeMe").hide();
		$("#editDialog").hide();
// 		closeDeleteDialog();
		$("#deleteDialog").fancybox();
		
		$(document).on('click','.openerEdit', function(e) {
 			e.preventDefault();
			openEditDialog();
			console.log($(this).parents('tr').find('.postcode').text());
			$("#editId").val($(this).attr('id'));
			$("#editCity").val($(this).parents('tr').find('.city').text());
			$("#editPostCode").val($(this).parents('tr').find('.postcode').text());
		});
		
		$(document).on('click','.openerDelete', function(e) {
 			e.preventDefault();
 			openDeleteDialog();
			console.log('Delete: ' + $(this).parents('tr').find('.postcode').text());
			$("#deleteId").val($(this).attr('id'));
		});
		
		$('#btnUpdateCity').click(function(e) {
            
            e.preventDefault();
            
            var formData = {
				'editId' :  $("#editId").val(),
				'editCity' : $("#editCity").val(),
				'editPostCode' : $("#editPostCode").val()
            };

			$.ajax({
			    url: "${pageContext.request.contextPath}/country/updatecity",
			    data: formData,
			    type: "GET",
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
				success: function(response) {
			     	
					fillDataTable(response);
				}
			});
            
	    });
		
		$('#btnDeleteCity').click(function(e) {
            
            e.preventDefault();
            
            var formData = {
				'deleteId' :  $("#deleteId").val()
            };

			$.ajax({
			    url: "${pageContext.request.contextPath}/country/deletecity",
			    data: formData,
			    type: "GET",
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
				success: function(response) {
			     	
					fillDataTable(response);
				}
			});
            
	    });
		
		$('#btnUpdateCancel').click(function(e) {
			$("#editDialog").hide();
		});
		
		$('#btnDeleteCancel').click(function(e) {
			closeDeleteDialog();
		});
		
		$("#countryCode").change(function(e) {
			
			e.preventDefault();
            
            var formData = {
				'countryCode' : $("#countryCode").val()
            };

			$.ajax({
			    url: "${pageContext.request.contextPath}/country/cities",
			    data: formData,
			    type: "GET",
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
				success: function(response) {
			     	
					fillDataTable(response);				
				}
			});
			
		});
		
	});
</script>

<h1>Country List</h1>

<div id="editDialog" style="height:150px !important;" title="Edit City">
	<form id="editCityForm">
		<input id="editId" type="text"/>
		<input id="editCity" type="text"/>
		<input id="editPostCode" type="text"/>
		<input id="btnUpdateCity" type="submit" value="OK"/>
		<input id="btnUpdateCancel" type="button" value="Cancel"/>
	</form>
</div>

<div id="deleteDialog" style="display:none;" title="Delete City">
	<form id="deleteCityForm">
		<h3>Are you sure you want to delete this city?</h3>
		<input id="deleteId" type="text"/>
		<input id="btnDeleteCity" type="submit" value="OK"/>
		<input id="btnDeleteCancel" type="button" value="Cancel"/>
	</form>
</div>


<div class="form_content">
	<form:form id="countryFormBean" commandName="countryFormBean">
		<form:label path="countryCode"><spring:message code="cargo.countryfrom"/></form:label>
		<form:select id="countryCode" path="countryCode">
			<form:option value=""><spring:message code="please.select.country" /></form:option>    							
			<c:forEach items="${countryCodes}" var="countryCode">
				<c:choose>
					<c:when test="${countryCode eq countryFormBean.countryCode}">
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
	</form:form>
	
	<table class="stripeMe sample"></table>
</div>