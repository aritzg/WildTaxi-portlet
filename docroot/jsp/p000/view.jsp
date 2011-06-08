<%@include file="/jsp/init.jsp"%>

<%
List<Request> requests = (List<Request>)request.getAttribute("requests");
Date loadTime = (Date)request.getAttribute("loadTime");
%>

<%=loadTime.getTime()%>

<portlet:resourceURL var="serveRes" />
<aui:script>
var delayed;
var millsDelay = 5000;
var lastTime=<%=loadTime.getTime()%>;
function <portlet:namespace />temporizeRequests(){
	AUI().use('aui-io-request, aui-delayed-task', function(A){
		delayed = new A.DelayedTask(getLastRequests);
		delayed.delay(millsDelay);
	});
}

function getLastRequests(){
	AUI().use('aui-io-request', function(A){	
		//get requests
  		A.io.request('<%=serveRes.toString()%>&resType=requests&lastTime='+lastTime , {
	  		on: {
		   		success: function() {
		   			//TODO:Pintar en el mapa las request obtenidas
		   			var items = this.get('responseData');
		   			var data;
		     		YUI().use("json", function (Y) {
						data = Y.JSON.parse(items);	 
					});
					for (var i = 0; i < data.list.length; i++) {
                 		lastTime=data.list[i].modifiedDate.time;
               		}
		   		}
		   	}
		});		
	});
	delayed.delay(millsDelay);
}

<portlet:namespace />temporizeRequests();
</aui:script>