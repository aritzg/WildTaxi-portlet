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
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.base.RequestLocalServiceBaseImpl;
import net.sareweb.wildtaxi.util.WTEvent;
import net.sareweb.wildtaxi.util.WTEventHandler;
import net.sareweb.wildtaxi.util.comparator.RequestBeginDateComparator;

/**
 * The implementation of the request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.sareweb.wildtaxi.service.RequestLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link net.sareweb.wildtaxi.service.RequestLocalServiceUtil} to access the request local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sareweb
 * @see net.sareweb.wildtaxi.service.base.RequestLocalServiceBaseImpl
 * @see net.sareweb.wildtaxi.service.RequestLocalServiceUtil
 */
public class RequestLocalServiceImpl extends RequestLocalServiceBaseImpl {
	
	@Override
	public Request addRequest(Request request) throws SystemException {
		Request r = super.addRequest(request);
		try {
			User u1 = UserLocalServiceUtil.getUser(request.getUserId());
			WTEventHandler.getInstance().addEvent(WTEvent.TYPE_CREATED_REQUEST, new Date(),u1, null, r, null);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	public List<Request> getRequestNewerThanDate(Date fromDate, float swLat, float swLng, float neLat, float neLng) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Request.class);
		Criterion modifiedDate = PropertyFactoryUtil.forName("beginDate").gt(fromDate);
		
		if(swLat!=0 && swLng!=0 && neLat!=0 && neLng!=0){
			Criterion minLat = PropertyFactoryUtil.forName("fromLat").gt(swLat);
			Criterion maxLat = PropertyFactoryUtil.forName("fromLat").lt(neLat);
			Criterion minLng = PropertyFactoryUtil.forName("fromLng").gt(swLng);
			Criterion maxLng = PropertyFactoryUtil.forName("fromLng").lt(neLng);
			dq.add(minLat).add(maxLat).add(minLng).add(maxLng);
		}

		dq.add(modifiedDate);
		return requestPersistence.findWithDynamicQuery(dq,0,10,new RequestBeginDateComparator());
	}
	
	public List<Request> getByUserId(long userId) throws SystemException {
		return requestPersistence.findByUserId(userId);
	}
}