<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<%
List<Request> myRequests = (List<Request>)request.getAttribute("myRequests");
%>
<liferay-portlet:renderURL var="addRequest">
	<liferay-portlet:param name="action" value="<%=MyRequestsPortlet._ACTION_ADD%>"></liferay-portlet:param>
</liferay-portlet:renderURL>
<div class="controls">
	<aui:button-row>
		<aui:button onClick="<%=addRequest%>" value="add"/>
	</aui:button-row>
</div>
<div class="myRequests">
	<div class="request-list">
		<liferay-ui:search-container delta='<%= new Integer(prefs.getValue("rowsPerPage", "10"))%>'>
			<liferay-ui:search-container-results
				results="<%=myRequests%>"
				total="<%=myRequests.size()%>" />
			
			<liferay-ui:search-container-row
				className="net.sareweb.wildtaxi.model.Request"
				keyProperty="requestId" modelVar="myRequest">
				
				<liferay-ui:search-container-column-text>
					<liferay-portlet:resourceURL var="requestDetail">
						<liferay-portlet:param name="jspPage" value="/jsp/p001/request_detail.jsp"/>
						<liferay-portlet:param name="resType" value="<%=MyRequestsPortlet._RES_TYPE_REQUEST_DETAILS %>"/>
						<liferay-portlet:param name="requestId" value="<%=String.valueOf(myRequest.getRequestId())%>"/>
					</liferay-portlet:resourceURL>
					<aui:a href='<%="javascript:refreshElementWithServedResource(\'request-detail\', \'" + requestDetail + "\')"%>'><%=myRequest.getName() %></aui:a>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
					<liferay-portlet:actionURL name="removeRequest" var="removeRequestURL">
						<liferay-portlet:param name="requestId" value="<%=String.valueOf(myRequest.getRequestId())%>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:icon-delete url="<%=removeRequestURL%>"></liferay-ui:icon-delete>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
	
	<div class="request-detail" id="request-detail">
		<div class="request-data">
					details
		</div>
		<div class="offers">
					offers
		</div>
		<div class="offer-messages">
					messages
		</div>
	</div>
	<div style="clear:both;"></div>
</div>