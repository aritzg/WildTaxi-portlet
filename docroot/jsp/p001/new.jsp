<%@include file="/jsp/init.jsp"%>
<liferay-portlet:actionURL var="addRequestURL"  name="addRequest"/>
<aui:form action="<%=addRequestURL%>" method="post" name="fm">
	<aui:fieldset>
		<aui:column>
			<aui:input name="name"></aui:input>
		</aui:column>
	</aui:fieldset>
	<aui:fieldset>
		<aui:column>
			<aui:input name="fromlat"></aui:input>
		</aui:column>
		<aui:column>
			<aui:input name="fromLng"></aui:input>
		</aui:column>
	</aui:fieldset>
	<aui:fieldset>
		<aui:column>
			<aui:input name="tolat"></aui:input>
		</aui:column>
		<aui:column>
			<aui:input name="toLng"></aui:input>
		</aui:column>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>