<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@page import="net.sareweb.wildtaxi.model.Request"%>
<%@page import="net.sareweb.wildtaxi.portlets.p000.ViewRequestsPortlet"%>
<%@page import="net.sareweb.wildtaxi.portlets.p001.MyRequestsPortlet"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences prefs = null;
if(renderRequest!=null)prefs = renderRequest.getPreferences();
%>

