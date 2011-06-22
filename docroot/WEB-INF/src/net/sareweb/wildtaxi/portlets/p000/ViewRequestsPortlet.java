package net.sareweb.wildtaxi.portlets.p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.wildtaxi.model.Message;
import net.sareweb.wildtaxi.model.Offer;
import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.MessageLocalServiceUtil;
import net.sareweb.wildtaxi.service.OfferLocalServiceUtil;
import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;
import net.sareweb.wildtaxi.util.WTEventHandler;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ViewRequestsPortlet extends MVCPortlet {

	private ThemeDisplay themeDisplay;
	
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
		else if(resType.equals(_RES_TYPE_INFO_WINDOW)){
			serveResourceInfoWindow(resourceRequest, resourceResponse);
			super.serveResource(resourceRequest, resourceResponse);
		}
		else if(resType.equals(_RES_TYPE_OFFER_WINDOW)){
			serveOfferWindow(resourceRequest, resourceResponse);
			super.serveResource(resourceRequest, resourceResponse);
		}
		else if(resType.equals(_RES_TYPE_SIDE_SHOW)){
			_log.debug("\tServing side show");
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	

	public void makeOffer(ActionRequest request, ActionResponse response)
			throws SystemException {
		themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long requestId = ParamUtil.getLong(request, "requestId", 0);
		_log.debug("User " + themeDisplay.getUserId() + " is making an offer to request " + requestId);
		
		//TODO: controlar la existencia de la request
		Offer offer = OfferLocalServiceUtil.createOffer(CounterLocalServiceUtil.increment(Offer.class.toString()));
		offer.setRequestId(requestId);
		//TODO Define offer states values
		offer.setState("");
		offer.setAgreementKey("");
		offer.setCompanyId(themeDisplay.getCompanyId());
		offer.setUserId(themeDisplay.getUserId());
		offer.setCreateDate(new Date());
		
		OfferLocalServiceUtil.addOffer(offer);
		
		Message msg = MessageLocalServiceUtil.createMessage(CounterLocalServiceUtil.increment(Message.class.toString()));
		msg.setOfferId(offer.getOfferId());
		msg.setMessage(ParamUtil.get(request, "offerText", ""));
		msg.setCompanyId(themeDisplay.getCompanyId());
		msg.setUserId(themeDisplay.getUserId());
		msg.setCreateDate(new Date());
		
		MessageLocalServiceUtil.addMessage(msg);
		
	}
	
	
	private void serveResourceRequests(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		long lastTime=ParamUtil.getLong(resourceRequest, "lastTime", System.currentTimeMillis());
		Date lastTimeDt = new Date();
		lastTimeDt.setTime(lastTime);
		
		float swLat = ParamUtil.getFloat(resourceRequest, "swLat", 0);
		float swLng = ParamUtil.getFloat(resourceRequest, "swLng", 0);
		float neLat = ParamUtil.getFloat(resourceRequest, "neLat", 0);
		float neLng = ParamUtil.getFloat(resourceRequest, "neLng", 0);
		
		
		_log.debug("\tServing requets modified after " +lastTimeDt.toString() + " sw:(" + swLat+ " , " + swLng + ") , (" + neLat + " , " + neLng + ")");
		

		List<Request> requests= new ArrayList<Request>();
		try {
			requests = RequestLocalServiceUtil.getRequestNewerThanDate(lastTimeDt, swLat, swLng, neLat, neLng);
			//requests = RequestLocalServiceUtil.getRequests(-1, -1);
			_log.debug("\t\t" + requests.size() + " request read.");
		} catch (SystemException e) {
			_log.error("Error getting requests!!", e);
		}
		
		resourceResponse.getWriter().write(JSONFactoryUtil.serialize(requests));
		
	}
	
	
	private void serveResourceInfoWindow(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		Long requestId = ParamUtil.getLong(resourceRequest, "requestId");
		_log.debug("\tServing requet info window for request " + requestId);
		try {
			Request request = RequestLocalServiceUtil.getRequest(requestId);
			resourceRequest.setAttribute("oneRequest", request);
		} catch (Exception e) {
			_log.error("No request found for " + requestId, e);
			return;
		}
	}
	
	private void serveOfferWindow(javax.portlet.ResourceRequest resourceRequest, javax.portlet.ResourceResponse resourceResponse) throws IOException ,PortletException {
		Long requestId = ParamUtil.getLong(resourceRequest, "requestId");
		_log.debug("\tServing offer window for request " + requestId);
		try {
			Request request = RequestLocalServiceUtil.getRequest(requestId);
			resourceRequest.setAttribute("oneRequest", request);
		} catch (Exception e) {
			_log.error("No request found for " + requestId, e);
			return;
		}
	}
	
	
	private String _RES_TYPE_REQUESTS="requests";
	private String _RES_TYPE_INFO_WINDOW="infoWindow";
	private String _RES_TYPE_OFFER_WINDOW="offerWindow";
	private String _RES_TYPE_SIDE_SHOW="sideShow";
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}
