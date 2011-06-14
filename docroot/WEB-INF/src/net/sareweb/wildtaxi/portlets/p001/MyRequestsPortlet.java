package net.sareweb.wildtaxi.portlets.p001;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;
import net.sareweb.wildtaxi.util.RequestUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class MyRequestsPortlet extends MVCPortlet {
	private ThemeDisplay themeDisplay;
	
	public void doView(RenderRequest request, RenderResponse response)
	throws IOException, PortletException {
		themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if(!themeDisplay.isSignedIn()){
			viewJSP = "/jsp/p001/not_logged.jsp";
		}
		else{
			String action = ParamUtil.get(request, "action", _ACTION_LIST);
	
			if(_ACTION_LIST.equals(action)){
				listMyRequests(request,  response);
			}
	
			if(_ACTION_ADD.equals(action)){
				viewJSP = "/jsp/p001/new.jsp";
			}
		}
		super.doView(request, response);
	}

	private void listMyRequests(RenderRequest request, RenderResponse response){
		try {
			_log.debug("Obtaining requests for user " + themeDisplay.getUserId());

			request.setAttribute("myRequests", RequestLocalServiceUtil.getByUserId(themeDisplay.getUserId()));
			
		} catch (SystemException e) {
			_log.error("Error obtaining my requests");
		}
		viewJSP = "/jsp/p001/view.jsp";
	}
	
	public void addRequest(ActionRequest request, ActionResponse response) throws SystemException{
		
		themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		_log.debug("Adding request for user " + themeDisplay.getUserId());
		Request r = RequestUtil.getFromRequest(request) ;
		RequestLocalServiceUtil.addRequest(r);
	}
	
	public void removeRequest(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long requestId = ParamUtil.getLong(request, "requestId", 0);
		if(requestId==0)return;
		RequestLocalServiceUtil.deleteRequest(requestId);
		//TODO:Handle dependencies
	}
	
	
	@Override
	public void serveResource(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		String resType=ParamUtil.getString(resourceRequest, "resType", "");
		_log.debug("Resouce requested: type = " + resType);

		if(resType.equals(_RES_TYPE_REQUEST_DETAILS)){
			serveResourceRequestDetail(resourceRequest, resourceResponse);
		}
		super.serveResource(resourceRequest, resourceResponse);
	};
	
	private void serveResourceRequestDetail(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		_log.debug("\tServing requets details");
		Long requestId = ParamUtil.getLong(resourceRequest, "requestId");
		try {
			Request request = RequestLocalServiceUtil.getRequest(requestId);
			resourceRequest.setAttribute("myRequest", request);
		} catch (Exception e) {
			_log.error("No request found for " + requestId, e);
			return;
		}
	}
		
	
	
	public static final String _ACTION_LIST = 	"LIST";
	public static final String _ACTION_ADD = 	"ADD";
	
	public static final String _RES_TYPE_REQUEST_DETAILS="requests";
	
	
	private static Log _log = LogFactoryUtil.getLog(MyRequestsPortlet.class);
}
