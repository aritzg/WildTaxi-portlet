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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ViewRequestsPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		String resType=ParamUtil.getString(resourceRequest, "resType", "");
		_log.debug("Resouce requested: type = " + resType);

		if(resType.equals(_RES_TYPE_REQUESTS)){
			serveResourceRequests(resourceRequest, resourceResponse);
		}
	};
	
	private void serveResourceRequests(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		long lastTime=ParamUtil.getLong(resourceRequest, "lastTime", System.currentTimeMillis());
		Date lastTimeDt = new Date();
		lastTimeDt.setTime(lastTime);
		_log.debug("\tServing requets modified after " +lastTimeDt.toString());
		

		List<Request> requests= new ArrayList<Request>();
		try {
			requests = RequestLocalServiceUtil.getRequestNewerThanDate(lastTimeDt);
			//requests = RequestLocalServiceUtil.getRequests(-1, -1);
			_log.debug("\t\t" + requests.size() + " request read.");
		} catch (SystemException e) {
			_log.error("Error getting requests!!", e);
		}
		
		resourceResponse.getWriter().write(JSONFactoryUtil.serialize(requests));
		
	};
	
	
	private String _RES_TYPE_REQUESTS="requests";
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}
