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

package net.sareweb.wildtaxi.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.sareweb.wildtaxi.model.Request;

/**
 * The persistence interface for the request service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sareweb
 * @see RequestPersistenceImpl
 * @see RequestUtil
 * @generated
 */
public interface RequestPersistence extends BasePersistence<Request> {
	/**
	* Caches the request in the entity cache if it is enabled.
	*
	* @param request the request to cache
	*/
	public void cacheResult(net.sareweb.wildtaxi.model.Request request);

	/**
	* Caches the requests in the entity cache if it is enabled.
	*
	* @param requests the requests to cache
	*/
	public void cacheResult(
		java.util.List<net.sareweb.wildtaxi.model.Request> requests);

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param requestId the primary key for the new request
	* @return the new request
	*/
	public net.sareweb.wildtaxi.model.Request create(long requestId);

	/**
	* Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the request to remove
	* @return the request that was removed
	* @throws net.sareweb.wildtaxi.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request remove(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchRequestException;

	public net.sareweb.wildtaxi.model.Request updateImpl(
		net.sareweb.wildtaxi.model.Request request, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the request with the primary key or throws a {@link net.sareweb.wildtaxi.NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request
	* @throws net.sareweb.wildtaxi.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request findByPrimaryKey(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchRequestException;

	/**
	* Finds the request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request, or <code>null</code> if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request fetchByPrimaryKey(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the requests where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @return the range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching request
	* @throws net.sareweb.wildtaxi.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchRequestException;

	/**
	* Finds the last request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching request
	* @throws net.sareweb.wildtaxi.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchRequestException;

	/**
	* Finds the requests before and after the current request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current request
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next request
	* @throws net.sareweb.wildtaxi.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Request[] findByUuid_PrevAndNext(
		long requestId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchRequestException;

	/**
	* Finds all the requests.
	*
	* @return the requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the requests.
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
	public java.util.List<net.sareweb.wildtaxi.model.Request> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.wildtaxi.model.Request> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the requests where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the requests where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}