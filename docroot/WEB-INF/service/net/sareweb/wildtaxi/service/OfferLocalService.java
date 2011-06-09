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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the offer local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link OfferLocalServiceUtil} to access the offer local service. Add custom service methods to {@link net.sareweb.wildtaxi.service.impl.OfferLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sareweb
 * @see OfferLocalServiceUtil
 * @see net.sareweb.wildtaxi.service.base.OfferLocalServiceBaseImpl
 * @see net.sareweb.wildtaxi.service.impl.OfferLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OfferLocalService {
	/**
	* Adds the offer to the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer to add
	* @return the offer that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Offer addOffer(
		net.sareweb.wildtaxi.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new offer with the primary key. Does not add the offer to the database.
	*
	* @param offerId the primary key for the new offer
	* @return the new offer
	*/
	public net.sareweb.wildtaxi.model.Offer createOffer(long offerId);

	/**
	* Deletes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param offerId the primary key of the offer to delete
	* @throws PortalException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the offer from the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteOffer(net.sareweb.wildtaxi.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the offer with the primary key.
	*
	* @param offerId the primary key of the offer to get
	* @return the offer
	* @throws PortalException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public net.sareweb.wildtaxi.model.Offer getOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the offers.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.sareweb.wildtaxi.model.Offer> getOffers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of offers.
	*
	* @return the number of offers
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOffersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the offer in the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer to update
	* @return the offer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Offer updateOffer(
		net.sareweb.wildtaxi.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the offer in the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer to update
	* @param merge whether to merge the offer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the offer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.wildtaxi.model.Offer updateOffer(
		net.sareweb.wildtaxi.model.Offer offer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;
}