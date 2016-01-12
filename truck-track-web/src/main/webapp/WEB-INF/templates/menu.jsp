<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="sidebar">
	<ul>
		<li><a href="<%=request.getContextPath()%>/messages">Messages</a></li>
		<li><a href="<%=request.getContextPath()%>/cargo/list">Cargo</a></li>
		<li><a href="<%=request.getContextPath()%>/vehicle/list">Vehicles</a></li>
		<li><a href="<%=request.getContextPath()%>/customer/list">Customers</a></li>
		<li><a href="<%=request.getContextPath()%>/register/form">Register</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="<%=request.getContextPath()%>/country/list">Countries</a></li>
			<li><a href="<%=request.getContextPath()%>/config">Configuration</a></li>
			<li><a href="<%=request.getContextPath()%>/datagenerator">Data Generator</a></li>			
		</sec:authorize>
	</ul>
</div>