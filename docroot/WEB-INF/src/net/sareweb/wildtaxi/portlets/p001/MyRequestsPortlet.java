package net.sareweb.wildtaxi.portlets.p001;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;

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
	
	public void addRequest(ActionRequest request, ActionResponse response){
		System.out.println("aaasdadadasd");
		themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		_log.debug("Adding request for user " + themeDisplay.getUserId());
	}
	
	
	public static final String _ACTION_LIST = 	"LIST";
	public static final String _ACTION_ADD = 	"ADD";
	
	private static Log _log = LogFactoryUtil.getLog(MyRequestsPortlet.class);
}
