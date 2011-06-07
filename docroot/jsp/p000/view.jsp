<%@include file="/jsp/init.jsp"%>

<%
List<Request> requests = (List<Request>)request.getAttribute("requests");
Date loadTime = (Date)request.getAttribute("loadTime");
%>

<%=loadTime.getTime()%>

<portlet:resourceURL var="serveRes" >
	<portlet:param name="resType" value="requests"></portlet:param>
</portlet:resourceURL>
<aui:script>
var delayed;
function <portlet:namespace />temporizeRequests(){
	AUI().use('aui-io-request, aui-delayed-task', function(A){
		delayed = new A.DelayedTask(getLastRequests);
		delayed.delay(1000);
	});
}

function getLastRequests(){
	AUI().use('aui-io-request', function(A){		
		A.io.request('<%=serveRes.toString()%>' , {
	  		on: {
		   		success: function() {
		   			//TODO:Pintar en el mapa las request obtenidas
		   		}
		   	}
		});
	});
	delayed.delay(1000);
}

<portlet:namespace />temporizeRequests();
</aui:script>