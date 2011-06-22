<%@include file="/jsp/init.jsp"%>
<%@page import="net.sareweb.wildtaxi.util.WTEvent"%>
<%@page import="net.sareweb.wildtaxi.util.WTEventHandler"%>


<%
for(int i=0; i<WTEventHandler.getInstance().getEvents().size(); i++){
	WTEvent event = (WTEvent)WTEventHandler.getInstance().getEvents().get(i);
%>
	<%
	if(event.getType().equals(WTEvent.TYPE_CREATED_REQUEST)){
	%>
	<div class="event-created">
		<div class="portrait">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=event.getU1().getPortraitId()%>">
		</div>
		<div class="info">Created request <%=event.getRequest().getName()%></div>
	</div>
	<%
	}
	%>
<%
}
%>
