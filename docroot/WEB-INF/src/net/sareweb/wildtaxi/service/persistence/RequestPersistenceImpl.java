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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.sareweb.wildtaxi.NoSuchRequestException;
import net.sareweb.wildtaxi.model.Request;
import net.sareweb.wildtaxi.model.impl.RequestImpl;
import net.sareweb.wildtaxi.model.impl.RequestModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the request service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sareweb
 * @see RequestPersistence
 * @see RequestUtil
 * @generated
 */
public class RequestPersistenceImpl extends BasePersistenceImpl<Request>
	implements RequestPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = RequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the request in the entity cache if it is enabled.
	 *
	 * @param request the request to cache
	 */
	public void cacheResult(Request request) {
		EntityCacheUtil.putResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey(), request);
	}

	/**
	 * Caches the requests in the entity cache if it is enabled.
	 *
	 * @param requests the requests to cache
	 */
	public void cacheResult(List<Request> requests) {
		for (Request request : requests) {
			if (EntityCacheUtil.getResult(
						RequestModelImpl.ENTITY_CACHE_ENABLED,
						RequestImpl.class, request.getPrimaryKey(), this) == null) {
				cacheResult(request);
			}
		}
	}

	/**
	 * Clears the cache for all requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(RequestImpl.class.getName());
		EntityCacheUtil.clearCache(RequestImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Request request) {
		EntityCacheUtil.removeResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey());
	}

	/**
	 * Creates a new request with the primary key. Does not add the request to the database.
	 *
	 * @param requestId the primary key for the new request
	 * @return the new request
	 */
	public Request create(long requestId) {
		Request request = new RequestImpl();

		request.setNew(true);
		request.setPrimaryKey(requestId);

		String uuid = PortalUUIDUtil.generate();

		request.setUuid(uuid);

		return request;
	}

	/**
	 * Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the request to remove
	 * @return the request that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the request to remove
	 * @return the request that was removed
	 * @throws net.sareweb.wildtaxi.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request remove(long requestId)
		throws NoSuchRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Request request = (Request)session.get(RequestImpl.class,
					new Long(requestId));

			if (request == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + requestId);
				}

				throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					requestId);
			}

			return remove(request);
		}
		catch (NoSuchRequestException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Request removeImpl(Request request) throws SystemException {
		request = toUnwrappedModel(request);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, request);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey());

		return request;
	}

	public Request updateImpl(net.sareweb.wildtaxi.model.Request request,
		boolean merge) throws SystemException {
		request = toUnwrappedModel(request);

		if (Validator.isNull(request.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			request.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, request, merge);

			request.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey(), request);

		return request;
	}

	protected Request toUnwrappedModel(Request request) {
		if (request instanceof RequestImpl) {
			return request;
		}

		RequestImpl requestImpl = new RequestImpl();

		requestImpl.setNew(request.isNew());
		requestImpl.setPrimaryKey(request.getPrimaryKey());

		requestImpl.setUuid(request.getUuid());
		requestImpl.setRequestId(request.getRequestId());
		requestImpl.setName(request.getName());
		requestImpl.setFromLat(request.getFromLat());
		requestImpl.setFromLng(request.getFromLng());
		requestImpl.setFromAddress(request.getFromAddress());
		requestImpl.setToLat(request.getToLat());
		requestImpl.setToLng(request.getToLng());
		requestImpl.setToAddress(request.getToAddress());
		requestImpl.setDistance(request.getDistance());
		requestImpl.setBeginDate(request.getBeginDate());
		requestImpl.setDuration(request.getDuration());
		requestImpl.setState(request.getState());
		requestImpl.setCompanyId(request.getCompanyId());
		requestImpl.setUserId(request.getUserId());
		requestImpl.setCreateDate(request.getCreateDate());
		requestImpl.setModifiedDate(request.getModifiedDate());

		return requestImpl;
	}

	/**
	 * Finds the request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the request to find
	 * @return the request
	 * @throws com.liferay.portal.NoSuchModelException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the request with the primary key or throws a {@link net.sareweb.wildtaxi.NoSuchRequestException} if it could not be found.
	 *
	 * @param requestId the primary key of the request to find
	 * @return the request
	 * @throws net.sareweb.wildtaxi.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request findByPrimaryKey(long requestId)
		throws NoSuchRequestException, SystemException {
		Request request = fetchByPrimaryKey(requestId);

		if (request == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + requestId);
			}

			throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				requestId);
		}

		return request;
	}

	/**
	 * Finds the request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the request to find
	 * @return the request, or <code>null</code> if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the request to find
	 * @return the request, or <code>null</code> if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Request fetchByPrimaryKey(long requestId) throws SystemException {
		Request request = (Request)EntityCacheUtil.getResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
				RequestImpl.class, requestId, this);

		if (request == null) {
			Session session = null;

			try {
				session = openSession();

				request = (Request)session.get(RequestImpl.class,
						new Long(requestId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (request != null) {
					cacheResult(request);
				}

				closeSession(session);
			}
		}

		return request;
	}

	/**
	 * Finds all the requests where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching requests
	 * @throws SystemException if a system exception occurred
	 */
	public List<Request> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Request> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	public List<Request> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Request> list = (List<Request>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_REQUEST_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Request>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Request findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRequestException, SystemException {
		List<Request> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRequestException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Request findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRequestException, SystemException {
		int count = countByUuid(uuid);

		List<Request> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRequestException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Request[] findByUuid_PrevAndNext(long requestId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRequestException, SystemException {
		Request request = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			Request[] array = new RequestImpl[3];

			array[0] = getByUuid_PrevAndNext(session, request, uuid,
					orderByComparator, true);

			array[1] = request;

			array[2] = getByUuid_PrevAndNext(session, request, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Request getByUuid_PrevAndNext(Session session, Request request,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REQUEST_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(request);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Request> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the requests.
	 *
	 * @return the requests
	 * @throws SystemException if a system exception occurred
	 */
	public List<Request> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Request> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Request> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Request> list = (List<Request>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUEST;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Request>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Request>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Request request : findByUuid(uuid)) {
			remove(request);
		}
	}

	/**
	 * Removes all the requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Request request : findAll()) {
			remove(request);
		}
	}

	/**
	 * Counts all the requests where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching requests
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REQUEST_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the requests.
	 *
	 * @return the number of requests
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REQUEST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.wildtaxi.model.Request")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Request>> listenersList = new ArrayList<ModelListener<Request>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Request>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(RequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = RequestPersistence.class)
	protected RequestPersistence requestPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_REQUEST = "SELECT request FROM Request request";
	private static final String _SQL_SELECT_REQUEST_WHERE = "SELECT request FROM Request request WHERE ";
	private static final String _SQL_COUNT_REQUEST = "SELECT COUNT(request) FROM Request request";
	private static final String _SQL_COUNT_REQUEST_WHERE = "SELECT COUNT(request) FROM Request request WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "request.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "request.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(request.uuid IS NULL OR request.uuid = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "request.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Request exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Request exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(RequestPersistenceImpl.class);
}