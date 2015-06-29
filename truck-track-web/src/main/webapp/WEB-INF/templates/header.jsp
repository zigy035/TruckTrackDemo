<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- <h3>Header</h3>
<p>Language: <a href="?lang=en">English</a> | <a href="?lang=de">Deutsch</a></p> -->
<div id="logo">
	<a href="index.html">
      <img src="<%=request.getContextPath()%>/styles/images/logo3.png" alt="TruckTrack Logo">
    </a>
</div><!-- kraj # logo-->

<div id="nav">
	<ul>
    	<li>Language:</li>
        <li><a href="?lang=en"><img src="<%=request.getContextPath()%>/styles/images/flags/UK_flag.png" alt="English"></a></li>
        <li>|</li>
        <li><a href="?lang=de"><img src="<%=request.getContextPath()%>/styles/images/flags/DE_flag.png" alt="Deutsch"></a></li>
    </ul>
</div>