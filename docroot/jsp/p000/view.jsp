<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<div class="wild-control-panel">
	<div class="pause" onclick="pause()">pause</div>
	<div class="play" onclick="play()">play</div>
</div> 

<div class="wild-map" id="map_canvas" style="width:65%; height:400px;">
</div>
<div class="side-show-container" >
	<div class="side-show-head">
		SideShow!!
	</div>
	<div class="side-show" id="sideShow">
	</div>
</div>
<div style="clear:both;"></div>

<portlet:resourceURL var="resURL" />


<aui:script>
initWildMap(document.getElementById('map_canvas'),'<%=resURL.toString()%>');
temporizeRequests();
temporizeSideShow();
</aui:script>