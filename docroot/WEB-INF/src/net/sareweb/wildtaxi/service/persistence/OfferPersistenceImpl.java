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

import net.sareweb.wildtaxi.NoSuchOfferException;
import net.sareweb.wildtaxi.model.Offer;
import net.sareweb.wildtaxi.model.impl.OfferImpl;
import net.sareweb.wildtaxi.model.impl.OfferModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the offer service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link OfferUtil} to access the offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sareweb
 * @see OfferPersistence
 * @see OfferUtil
 * @generated
 */
public class OfferPersistenceImpl extends BasePersistenceImpl<Offer>
	implements OfferPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OfferImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer to cache
	 */
	public void cacheResult(Offer offer) {
		EntityCacheUtil.putResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey(), offer);
	}

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers to cache
	 */
	public void cacheResult(List<Offer> offers) {
		for (Offer offer : offers) {
			if (EntityCacheUtil.getResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
						OfferImpl.class, offer.getPrimaryKey(), this) == null) {
				cacheResult(offer);
			}
		}
	}

	/**
	 * Clears the cache for all offers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(OfferImpl.class.getName());
		EntityCacheUtil.clearCache(OfferImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the offer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Offer offer) {
		EntityCacheUtil.removeResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey());
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	public Offer create(long offerId) {
		Offer offer = new OfferImpl();

		offer.setNew(true);
		offer.setPrimaryKey(offerId);

		String uuid = PortalUUIDUtil.generate();

		offer.setUuid(uuid);

		return offer;
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the offer to remove
	 * @return the offer that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param offerId the primary key of the offer to remove
	 * @return the offer that was removed
	 * @throws net.sareweb.wildtaxi.NoSuchOfferException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer remove(long offerId)
		throws NoSuchOfferException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Offer offer = (Offer)session.get(OfferImpl.class, new Long(offerId));

			if (offer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + offerId);
				}

				throw new NoSuchOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					offerId);
			}

			return remove(offer);
		}
		catch (NoSuchOfferException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Offer removeImpl(Offer offer) throws SystemException {
		offer = toUnwrappedModel(offer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, offer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey());

		return offer;
	}

	public Offer updateImpl(net.sareweb.wildtaxi.model.Offer offer,
		boolean merge) throws SystemException {
		offer = toUnwrappedModel(offer);

		if (Validator.isNull(offer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			offer.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, offer, merge);

			offer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey(), offer);

		return offer;
	}

	protected Offer toUnwrappedModel(Offer offer) {
		if (offer instanceof OfferImpl) {
			return offer;
		}

		OfferImpl offerImpl = new OfferImpl();

		offerImpl.setNew(offer.isNew());
		offerImpl.setPrimaryKey(offer.getPrimaryKey());

		offerImpl.setUuid(offer.getUuid());
		offerImpl.setOfferId(offer.getOfferId());
		offerImpl.setRequestId(offer.getRequestId());
		offerImpl.setState(offer.getState());
		offerImpl.setAgreementKey(offer.getAgreementKey());
		offerImpl.setCompanyId(offer.getCompanyId());
		offerImpl.setUserId(offer.getUserId());
		offerImpl.setCreateDate(offer.getCreateDate());

		return offerImpl;
	}

	/**
	 * Finds the offer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the offer to find
	 * @return the offer
	 * @throws com.liferay.portal.NoSuchModelException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the offer with the primary key or throws a {@link net.sareweb.wildtaxi.NoSuchOfferException} if it could not be found.
	 *
	 * @param offerId the primary key of the offer to find
	 * @return the offer
	 * @throws net.sareweb.wildtaxi.NoSuchOfferException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer findByPrimaryKey(long offerId)
		throws NoSuchOfferException, SystemException {
		Offer offer = fetchByPrimaryKey(offerId);

		if (offer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + offerId);
			}

			throw new NoSuchOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				offerId);
		}

		return offer;
	}

	/**
	 * Finds the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the offer to find
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer to find
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer fetchByPrimaryKey(long offerId) throws SystemException {
		Offer offer = (Offer)EntityCacheUtil.getResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
				OfferImpl.class, offerId, this);

		if (offer == null) {
			Session session = null;

			try {
				session = openSession();

				offer = (Offer)session.get(OfferImpl.class, new Long(offerId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (offer != null) {
					cacheResult(offer);
				}

				closeSession(session);
			}
		}

		return offer;
	}

	/**
	 * Finds all the offers where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of offers to return
	 * @param end the upper bound of the range of offers to return (not inclusive)
	 * @return the range of matching offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of offers to return
	 * @param end the upper bound of the range of offers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Offer> list = (List<Offer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_OFFER_WHERE);

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

				list = (List<Offer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Finds the first offer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching offer
	 * @throws net.sareweb.wildtaxi.NoSuchOfferException if a matching offer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOfferException, SystemException {
		List<Offer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOfferException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last offer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching offer
	 * @throws net.sareweb.wildtaxi.NoSuchOfferException if a matching offer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOfferException, SystemException {
		int count = countByUuid(uuid);

		List<Offer> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOfferException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the offers before and after the current offer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param offerId the primary key of the current offer
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next offer
	 * @throws net.sareweb.wildtaxi.NoSuchOfferException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer[] findByUuid_PrevAndNext(long offerId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOfferException, SystemException {
		Offer offer = findByPrimaryKey(offerId);

		Session session = null;

		try {
			session = openSession();

			Offer[] array = new OfferImpl[3];

			array[0] = getByUuid_PrevAndNext(session, offer, uuid,
					orderByComparator, true);

			array[1] = offer;

			array[2] = getByUuid_PrevAndNext(session, offer, uuid,
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

	protected Offer getByUuid_PrevAndNext(Session session, Offer offer,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFER_WHERE);

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
			Object[] values = orderByComparator.getOrderByValues(offer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Offer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the offers.
	 *
	 * @return the offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers to return
	 * @param end the upper bound of the range of offers to return (not inclusive)
	 * @return the range of offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers to return
	 * @param end the upper bound of the range of offers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Offer> list = (List<Offer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Offer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Offer>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Offer offer : findByUuid(uuid)) {
			remove(offer);
		}
	}

	/**
	 * Removes all the offers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Offer offer : findAll()) {
			remove(offer);
		}
	}

	/**
	 * Counts all the offers where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching offers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFER_WHERE);

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
	 * Counts all the offers.
	 *
	 * @return the number of offers
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

				Query q = session.createQuery(_SQL_COUNT_OFFER);

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
	 * Initializes the offer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.wildtaxi.model.Offer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Offer>> listenersList = new ArrayList<ModelListener<Offer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Offer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfferImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = RequestPersistence.class)
	protected RequestPersistence requestPersistence;
	@BeanReference(type = OfferPersistence.class)
	protected OfferPersistence offerPersistence;
	@BeanReference(type = MessagePersistence.class)
	protected MessagePersistence messagePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_OFFER = "SELECT offer FROM Offer offer";
	private static final String _SQL_SELECT_OFFER_WHERE = "SELECT offer FROM Offer offer WHERE ";
	private static final String _SQL_COUNT_OFFER = "SELECT COUNT(offer) FROM Offer offer";
	private static final String _SQL_COUNT_OFFER_WHERE = "SELECT COUNT(offer) FROM Offer offer WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "offer.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "offer.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(offer.uuid IS NULL OR offer.uuid = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "offer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Offer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Offer exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(OfferPersistenceImpl.class);
}