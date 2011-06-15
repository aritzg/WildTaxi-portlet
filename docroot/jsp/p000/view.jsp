<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<div class="wild-map" id="map_canvas" style="width:600px; height:400px;">

</div>

<portlet:resourceURL var="getRequests" />
<portlet:resourceURL var="getInfoWindow" >
	<portlet:param name="jspPage" value="/jsp/mapInfoWindow.jsp"></portlet:param>
</portlet:resourceURL>
<aui:script>
lastTime=0;
temporizeRequests('<%=getRequests.toString()%>');
initWildMap(document.getElementById('map_canvas'),'<%=getInfoWindow.toString()%>');
</aui:script>