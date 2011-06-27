<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

<liferay-portlet:actionURL var="addRequestURL"  name="addRequest"/>

<aui:form action="<%=addRequestURL%>" method="post" name="fm">
<div class="new-request">
	<div class="request-data">
		<aui:fieldset>
			<aui:column>
				<aui:input name="name" ></aui:input>
			</aui:column>
			<aui:column>
				<aui:input name="distance" id="distanceId"></aui:input>
			</aui:column>
			<aui:column>
				<aui:field-wrapper label="aaa">
					<liferay-ui:input-date yearRangeEnd="2013" yearRangeStart="2011" ></liferay-ui:input-date>
					<liferay-ui:input-time minuteParam="minuteParam" amPmParam="amPmParam" hourParam="hourParam"></liferay-ui:input-time>
				</aui:field-wrapper>
			</aui:column>
		</aui:fieldset>
		<aui:fieldset>
			<aui:column>
				<aui:input name="fromLat" id="fromLatId"></aui:input>
			</aui:column>
			<aui:column>
				<aui:input name="fromLng" id="fromLngId"></aui:input>
			</aui:column>
			<aui:column>
				<aui:input name="fromAddress" id="fromAddressId"></aui:input>
			</aui:column>
		</aui:fieldset>
		<aui:fieldset>
			<aui:column>
				<aui:input name="toLat" id="toLatId"></aui:input>
			</aui:column>
			<aui:column>
				<aui:input name="toLng" id="toLngId"></aui:input>
			</aui:column>
			<aui:column>
				<aui:input name="toAddress" id="toAddressId"></aui:input>
			</aui:column>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit"/>
		</aui:button-row>
	</div>
	<div class="new-request-map">
		<div class="request-from-to">
			<aui:button-row>
				<aui:button onClick="selectSourceOrDest('source')" value="from"/>
				<aui:button onClick="selectSourceOrDest('dest')" value="to"/>
			</aui:button-row>
		</div>
		<div id="map_canvas"></div>
	</div>
	<div style="clear: both;"></div>
</div>
</aui:form>

<aui:script>
	initRequestCreateMap(document.getElementById('map_canvas'),document.getElementById('<portlet:namespace/>fromLatId'),document.getElementById('<portlet:namespace/>fromLngId'),document.getElementById('<portlet:namespace/>fromAddressId'),document.getElementById('<portlet:namespace/>toLatId'),document.getElementById('<portlet:namespace/>toLngId'),document.getElementById('<portlet:namespace/>toAddressId'),document.getElementById('<portlet:namespace/>distanceId'));
</aui:script>


