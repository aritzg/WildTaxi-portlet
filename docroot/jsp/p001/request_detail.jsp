<%@include file="/jsp/init.jsp"%>
<%
Request myRequest = (Request)request.getAttribute("myRequest");
%>
<div class="request-data">
	<div class="request-map" id="map_canvas" style="width:200px; height:200px;">
	</div>
	<div class="request-info">
		<aui:panel collapsible="false">
			<%=myRequest.getName()%>
		</aui:panel>
	</div>
	<div style="clear:both;"></div>
</div>
<div class="offers">
			offers
</div>
<div class="offer-messages">
			messages
</div>
<aui:script>
	initRequestDetailMap(document.getElementById('map_canvas'),<%=myRequest.getFromLat()%>,<%=myRequest.getFromLng()%>,<%=myRequest.getToLat()%>,<%=myRequest.getToLng()%>);
</aui:script>