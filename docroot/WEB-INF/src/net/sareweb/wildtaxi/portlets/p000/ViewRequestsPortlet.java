package net.sareweb.wildtaxi.portlets.p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ViewRequestsPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		List<Request> requests= new ArrayList<Request>();
		try {
			requests = RequestLocalServiceUtil.getRequests(-1, -1);
			_log.debug(requests.size() + " request read.");
		} catch (SystemException e) {
			_log.error("Error getting requests!!", e);
		}
		renderRequest.setAttribute("requests", requests);
		renderRequest.setAttribute("loadTime", new Date());
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		_log.debug("Resouce requested");
	};
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}
