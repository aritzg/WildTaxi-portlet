<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<div class="wild-map" id="map_canvas" style="width:600px; height:400px;">
</div>
<div class="side-show-container" >
	SideShow!!
	<div class="side-show" id="sideShow">
	</div>
</div>

<portlet:resourceURL var="resURL" />

<aui:script>
lastTime=0;
initWildMap(document.getElementById('map_canvas'),'<%=resURL.toString()%>');
temporizeRequests();
temporizeSideShow();
</aui:script>