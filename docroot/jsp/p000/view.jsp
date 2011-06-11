<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<div class="wild-map" id="map_canvas" style="width:600px; height:400px;">

</div>

<portlet:resourceURL var="serveRes" />
<aui:script>
lastTime=0;
servResourceUrl = '<%=serveRes.toString()%>';
temporizeRequests();
initWildMap(document.getElementById('map_canvas'));
</aui:script>