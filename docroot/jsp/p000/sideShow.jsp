<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/jsp/init.jsp"%>
<%@page import="net.sareweb.wildtaxi.util.WTEvent"%>
<%@page import="net.sareweb.wildtaxi.util.WTEventHandler"%>


<%
String aaa = ParamUtil.get(request, "resType", "asdasdasdasd");
long time = ParamUtil.getLong(request, "lastTimeSideShow", 0);
List<WTEvent> newestEvents = WTEventHandler.getInstance().getEvents(time); 
for(int i=0; i<newestEvents.size(); i++){
	WTEvent event = (WTEvent)newestEvents.get(i);
%>
	<%
	if(event.getType().equals(WTEvent.TYPE_CREATED_REQUEST)){
	%>
	<div class="event created">
		<div class="portrait">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=event.getU1().getPortraitId()%>">
		</div>
		<div class="info">Created request <%=event.getRequest().getName()%></div>
	</div>
	<%
	}
	else if(event.getType().equals(WTEvent.TYPE_MADE_OFFER)){
	%>
	<div class="event offer">
		<div class="portrait">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=event.getU1().getPortraitId()%>">
		</div>
		<div class="info">Created request <%=event.getRequest().getName()%></div>
		<div class="portrait2">
		<img src="<%= themeDisplay.getPathImage() %>/user_portrait?img_id=<%=event.getU2().getPortraitId()%>">
		</div>
	</div>
	<%
	}
	%>
<%
}
%>
