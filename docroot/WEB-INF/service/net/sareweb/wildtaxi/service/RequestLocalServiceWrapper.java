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

package net.sareweb.wildtaxi.service;

/**
 * <p>
 * This class is a wrapper for {@link RequestLocalService}.
 * </p>
 *
 * @author    Sareweb
 * @see       RequestLocalService
 * @generated
 */
public class RequestLocalServiceWrapper implements RequestLocalService {
	public RequestLocalServiceWrapper(RequestLocalService requestLocalService) {
		_requestLocalService = requestLocalService;
	}

	/**
	* Adds the request to the database. Also notifies the appropriate model listeners.
	*
	* @param request the request to add
	* @return the request that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request addRequest(
		net.sareweb.wildtaxi.model.Request request)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.addRequest(request);
	}

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param requestId the primary key for the new request
	* @return the new request
	*/
	public net.sareweb.wildtaxi.model.Request createRequest(long requestId) {
		return _requestLocalService.createRequest(requestId);
	}

	/**
	* Deletes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the request to delete
	* @throws PortalException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_requestLocalService.deleteRequest(requestId);
	}

	/**
	* Deletes the request from the database. Also notifies the appropriate model listeners.
	*
	* @param request the request to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRequest(net.sareweb.wildtaxi.model.Request request)
		throws com.liferay.portal.kernel.exception.SystemException {
		_requestLocalService.deleteRequest(request);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the request with the primary key.
	*
	* @param requestId the primary key of the request to get
	* @return the request
	* @throws PortalException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request getRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.getRequest(requestId);
	}

	/**
	* Gets a range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @return the range of requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> getRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.getRequests(start, end);
	}

	/**
	* Gets the number of requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public int getRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.getRequestsCount();
	}

	/**
	* Updates the request in the database. Also notifies the appropriate model listeners.
	*
	* @param request the request to update
	* @return the request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request updateRequest(
		net.sareweb.wildtaxi.model.Request request)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.updateRequest(request);
	}

	/**
	* Updates the request in the database. Also notifies the appropriate model listeners.
	*
	* @param request the request to update
	* @param merge whether to merge the request with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request updateRequest(
		net.sareweb.wildtaxi.model.Request request, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.updateRequest(request, merge);
	}

	public java.util.List<net.sareweb.wildtaxi.model.Request> getRequestNewerThanDate(
		java.util.Date fromDate, float swLat, float swLng, float neLat,
		float neLng) throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.getRequestNewerThanDate(fromDate, swLat,
			swLng, neLat, neLng);
	}

	public java.util.List<net.sareweb.wildtaxi.model.Request> getByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _requestLocalService.getByUserId(userId);
	}

	public RequestLocalService getWrappedRequestLocalService() {
		return _requestLocalService;
	}

	private RequestLocalService _requestLocalService;
}