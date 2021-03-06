/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.sareweb.wildtaxi.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import net.sareweb.wildtaxi.model.Offer;
import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.RequestLocalServiceUtil;
import net.sareweb.wildtaxi.service.base.OfferLocalServiceBaseImpl;
import net.sareweb.wildtaxi.util.WTEvent;
import net.sareweb.wildtaxi.util.WTEventHandler;

/**
 * The implementation of the offer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.sareweb.wildtaxi.service.OfferLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link net.sareweb.wildtaxi.service.OfferLocalServiceUtil} to access the offer local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sareweb
 * @see net.sareweb.wildtaxi.service.base.OfferLocalServiceBaseImpl
 * @see net.sareweb.wildtaxi.service.OfferLocalServiceUtil
 */
public class OfferLocalServiceImpl extends OfferLocalServiceBaseImpl {
	
	@Override
	public Offer addOffer(Offer offer) throws SystemException {
		Offer o = super.addOffer(offer);
		try {
			Request r = RequestLocalServiceUtil.getRequest(o.getRequestId());
			User u1 = UserLocalServiceUtil.getUser(o.getUserId());
			User u2 = UserLocalServiceUtil.getUser(r.getUserId());
			WTEventHandler.getInstance().addEvent(WTEvent.TYPE_MADE_OFFER, new Date(),u1, u2, r, o);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return o;
	}
	
}