<%@include file="/jsp/init.jsp"%>
<%
Request oneRequest = (Request)request.getAttribute("oneRequest");
%>
<portlet:resourceURL var="offerTravelURL" >
	<portlet:param name="resType" value="offerWindow"></portlet:param>
	<portlet:param name="jspPage" value="/jsp/p000/offerTravel.jsp"></portlet:param>
</portlet:resourceURL>

<div class="info-window">
	<div class="info-name">
		<%=oneRequest.getName()%> , <%=oneRequest.getDistance()/1000 %>Km. 
		<span>
			<aui:a href='<%="javascript:popUp(\'" + offerTravelURL.toString() + "\', 600, 400)" %>'>Offer</aui:a>
		</span>
	</div>
	<div class="info-portrait">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=themeDisplay.getUser().getPortraitId()%>">
	</div>
	<div class="info-data">
		<div class="info-data-from">
			<%= oneRequest.getFromAddress() + "(" + oneRequest.getFromLat() + "," + oneRequest.getFromLng() + ")"%>
		</div>
		<div class="info-data-to">
			<%= oneRequest.getToAddress() + "(" + oneRequest.getToLat() + "," + oneRequest.getToLng() + ")"%>
		</div>
	</div>
	<div style="clear:both"></div>
</div>