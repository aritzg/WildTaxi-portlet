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
import com.liferay.portal.kernel.exception.SystemException;

import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.service.base.RequestLocalServiceBaseImpl;
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
	public List<Request> getRequestNewerThanDate(Date fromDate) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Request.class);
		Criterion modifiedDate = PropertyFactoryUtil.forName("beginDate").gt(fromDate);	
		dq.add(modifiedDate);
		return requestPersistence.findWithDynamicQuery(dq,0,10,new RequestBeginDateComparator());
	}
	
	public List<Request> getByUserId(long userId) throws SystemException {
		return requestPersistence.findByUserId(userId);
	}
}