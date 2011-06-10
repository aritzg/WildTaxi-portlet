package net.sareweb.wildtaxi.util;

import java.util.Date;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;

public class RequestUtil {

	public static Request getFromRequest(ActionRequest actionRequest) throws SystemException{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Request r = RequestLocalServiceUtil.createRequest(CounterLocalServiceUtil.increment(Request.class.toString()));
		r.setName(ParamUtil.getString(actionRequest, "name",""));
		r.setFromLat(ParamUtil.getFloat(actionRequest, "fromLat",0));
		r.setFromLng(ParamUtil.getFloat(actionRequest, "fromLng",0));
		r.setToLat(ParamUtil.getFloat(actionRequest, "toLat",0));
		r.setToLng(ParamUtil.getFloat(actionRequest, "toLng",0));
		
		r.setBeginDate(new Date());
		r.setCreateDate(new Date());
		r.setModifiedDate(new Date());
		
		r.setUserId(themeDisplay.getUserId());
		r.setCompanyId(themeDisplay.getCompanyId());
		return r;
	}
}
