<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<%
List<Request> requests = (List<Request>)request.getAttribute("requests");
Date loadTime = (Date)request.getAttribute("loadTime");
%>

<%=loadTime.getTime()%>


<portlet:resourceURL var="serveRes" />
<aui:script>
lastTime=<%=loadTime.getTime()%>;
servResourceUrl = '<%=serveRes.toString()%>';
temporizeRequests();
</aui:script>