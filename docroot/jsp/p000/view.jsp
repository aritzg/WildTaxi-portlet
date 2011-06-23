<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<div class="wild-control-panel">
	<div class="pause">pause</div>
	<div class="play">play</div>
</div> 

<div class="wild-map" id="map_canvas" style="width:800px; height:400px;">
</div>
<div class="side-show-container" >
	SideShow!!
	<div class="side-show" id="sideShow">
	</div>
</div>
<div style="clear:both;"></div>

<portlet:resourceURL var="resURL" />


<aui:script>
lastTime=0;
initWildMap(document.getElementById('map_canvas'),'<%=resURL.toString()%>');
temporizeRequests();
temporizeSideShow();
</aui:script>