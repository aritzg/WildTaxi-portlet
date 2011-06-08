<%@include file="/jsp/init.jsp"%>
<%
List<Request> myRequests = (List<Request>)request.getAttribute("myRequests");
%>

<div class="myRequests">
	<div class="request-list">
		<liferay-ui:search-container delta='<%= new Integer(prefs.getValue("rowsPerPage", "10"))%>'>
			<liferay-ui:search-container-results
				results="<%=myRequests%>"
				total="<%=myRequests.size()%>" />
			
			<liferay-ui:search-container-row
				className="net.sareweb.wildtaxi.model.Request"
				keyProperty="requestId" modelVar="myRequest">
				
				<liferay-ui:search-container-column-text name="name" value="<%=myRequest.getName() %>" />
				
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
	
	<div class="request-detail">
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
</div>