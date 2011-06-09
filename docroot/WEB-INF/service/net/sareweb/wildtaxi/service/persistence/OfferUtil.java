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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import net.sareweb.wildtaxi.model.Offer;

import java.util.List;

/**
 * The persistence utility for the offer service. This utility wraps {@link OfferPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sareweb
 * @see OfferPersistence
 * @see OfferPersistenceImpl
 * @generated
 */
public class OfferUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Offer offer) {
		getPersistence().clearCache(offer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Offer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Offer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Offer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Offer remove(Offer offer) throws SystemException {
		return getPersistence().remove(offer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Offer update(Offer offer, boolean merge)
		throws SystemException {
		return getPersistence().update(offer, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Offer update(Offer offer, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(offer, merge, serviceContext);
	}

	/**
	* Caches the offer in the entity cache if it is enabled.
	*
	* @param offer the offer to cache
	*/
	public static void cacheResult(net.sareweb.wildtaxi.model.Offer offer) {
		getPersistence().cacheResult(offer);
	}

	/**
	* Caches the offers in the entity cache if it is enabled.
	*
	* @param offers the offers to cache
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.wildtaxi.model.Offer> offers) {
		getPersistence().cacheResult(offers);
	}

	/**
	* Creates a new offer with the primary key. Does not add the offer to the database.
	*
	* @param offerId the primary key for the new offer
	* @return the new offer
	*/
	public static net.sareweb.wildtaxi.model.Offer create(long offerId) {
		return getPersistence().create(offerId);
	}

	/**
	* Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param offerId the primary key of the offer to remove
	* @return the offer that was removed
	* @throws net.sareweb.wildtaxi.NoSuchOfferException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.wildtaxi.model.Offer remove(long offerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchOfferException {
		return getPersistence().remove(offerId);
	}

	public static net.sareweb.wildtaxi.model.Offer updateImpl(
		net.sareweb.wildtaxi.model.Offer offer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(offer, merge);
	}

	/**
	* Finds the offer with the primary key or throws a {@link net.sareweb.wildtaxi.NoSuchOfferException} if it could not be found.
	*
	* @param offerId the primary key of the offer to find
	* @return the offer
	* @throws net.sareweb.wildtaxi.NoSuchOfferException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.wildtaxi.model.Offer findByPrimaryKey(
		long offerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchOfferException {
		return getPersistence().findByPrimaryKey(offerId);
	}

	/**
	* Finds the offer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param offerId the primary key of the offer to find
	* @return the offer, or <code>null</code> if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.wildtaxi.model.Offer fetchByPrimaryKey(
		long offerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(offerId);
	}

	/**
	* Finds all the offers where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching offers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
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
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static net.sareweb.wildtaxi.model.Offer findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchOfferException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
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
	public static net.sareweb.wildtaxi.model.Offer findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchOfferException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
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
	public static net.sareweb.wildtaxi.model.Offer[] findByUuid_PrevAndNext(
		long offerId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.wildtaxi.NoSuchOfferException {
		return getPersistence()
				   .findByUuid_PrevAndNext(offerId, uuid, orderByComparator);
	}

	/**
	* Finds all the offers.
	*
	* @return the offers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<net.sareweb.wildtaxi.model.Offer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the offers where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the offers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the offers where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching offers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Counts all the offers.
	*
	* @return the number of offers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OfferPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OfferPersistence)PortletBeanLocatorUtil.locate(net.sareweb.wildtaxi.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					OfferPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(OfferPersistence persistence) {
		_persistence = persistence;
	}

	private static OfferPersistence _persistence;
}