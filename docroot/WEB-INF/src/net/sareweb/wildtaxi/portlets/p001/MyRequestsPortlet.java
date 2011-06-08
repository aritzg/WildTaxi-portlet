package net.sareweb.wildtaxi.portlets.p001;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.wildtaxi.model.Request;
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
				//TODO
			}
		}
		super.doView(request, response);
	}

	private void listMyRequests(RenderRequest request, RenderResponse response){
		try {
			_log.debug("Obtaining requests for user " + themeDisplay.getUserId());

			request.setAttribute("myRequests", RequestLocalServiceUtil.getRequests(-1, -1));
			
		} catch (SystemException e) {
			_log.error("Error obtaining my requests");
		}
		viewJSP = "/jsp/p001/view.jsp";
	}
	
	
	public static final String _ACTION_LIST = 	"LIST";
	public static final String _ACTION_ADD = 	"ADD";
	
	private static Log _log = LogFactoryUtil.getLog(MyRequestsPortlet.class);
}
