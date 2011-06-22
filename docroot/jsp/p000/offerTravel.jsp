<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@include file="/jsp/init.jsp"%>
<%
Request oneRequest = (Request)request.getAttribute("oneRequest");
%>

<div class="info-window">
	<div class="info-name">
		<%=oneRequest.getName()%> , <%=oneRequest.getDistance()/1000 %>Km. 

	</div>
	<div class="info-portrait">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=UserLocalServiceUtil.getUser(oneRequest.getUserId()).getPortraitId()%>">
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


<liferay-portlet:actionURL var="makeOfferURL"  name="makeOffer">
	<liferay-portlet:param name="requestId" value="<%=String.valueOf(oneRequest.getRequestId())%>"></liferay-portlet:param>
</liferay-portlet:actionURL>
<aui:form action="<%=makeOfferURL%>" method="post" name="fm">

<div class="offer-text">
	<aui:input name="offerText" type="textarea"></aui:input>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>	
</div>

</aui:form>