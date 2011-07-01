package net.sareweb.wildtaxi.util;

import java.util.Date;
import java.util.GregorianCalendar;

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
		r.setDistance(ParamUtil.getLong(actionRequest, "distance",0));
		
		int beginYear = ParamUtil.getInteger(actionRequest, "beginYear");
		int beginMonth = ParamUtil.getInteger(actionRequest, "beginMonth");
		int beginDay = ParamUtil.getInteger(actionRequest, "beginDay");
		int beginHour = ParamUtil.getInteger(actionRequest, "beginHour");
		int beginMinute = ParamUtil.getInteger(actionRequest, "beginMinute");
		int beginAmPm = ParamUtil.getInteger(actionRequest, "beginAmPm");
		
		GregorianCalendar beginCal = new GregorianCalendar(beginYear, beginMonth, beginDay, beginHour + (12*beginAmPm), beginMinute);
		
		r.setBeginDate(beginCal.getTime());
		r.setCreateDate(new Date());
		r.setModifiedDate(new Date());
		
		r.setUserId(themeDisplay.getUserId());
		r.setCompanyId(themeDisplay.getCompanyId());
		return r;
	}
}
