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

package net.sareweb.wildtaxi.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.sareweb.wildtaxi.service.MessageLocalService;
import net.sareweb.wildtaxi.service.MessageService;
import net.sareweb.wildtaxi.service.OfferLocalService;
import net.sareweb.wildtaxi.service.OfferService;
import net.sareweb.wildtaxi.service.RequestLocalService;
import net.sareweb.wildtaxi.service.RequestService;
import net.sareweb.wildtaxi.service.persistence.MessagePersistence;
import net.sareweb.wildtaxi.service.persistence.OfferPersistence;
import net.sareweb.wildtaxi.service.persistence.RequestPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the request remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.sareweb.wildtaxi.service.impl.RequestServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link net.sareweb.wildtaxi.service.RequestServiceUtil} to access the request remote service.
 * </p>
 *
 * @author Sareweb
 * @see net.sareweb.wildtaxi.service.impl.RequestServiceImpl
 * @see net.sareweb.wildtaxi.service.RequestServiceUtil
 * @generated
 */
public abstract class RequestServiceBaseImpl extends PrincipalBean
	implements RequestService {
	/**
	 * Gets the request local service.
	 *
	 * @return the request local service
	 */
	public RequestLocalService getRequestLocalService() {
		return requestLocalService;
	}

	/**
	 * Sets the request local service.
	 *
	 * @param requestLocalService the request local service
	 */
	public void setRequestLocalService(RequestLocalService requestLocalService) {
		this.requestLocalService = requestLocalService;
	}

	/**
	 * Gets the request remote service.
	 *
	 * @return the request remote service
	 */
	public RequestService getRequestService() {
		return requestService;
	}

	/**
	 * Sets the request remote service.
	 *
	 * @param requestService the request remote service
	 */
	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	/**
	 * Gets the request persistence.
	 *
	 * @return the request persistence
	 */
	public RequestPersistence getRequestPersistence() {
		return requestPersistence;
	}

	/**
	 * Sets the request persistence.
	 *
	 * @param requestPersistence the request persistence
	 */
	public void setRequestPersistence(RequestPersistence requestPersistence) {
		this.requestPersistence = requestPersistence;
	}

	/**
	 * Gets the offer local service.
	 *
	 * @return the offer local service
	 */
	public OfferLocalService getOfferLocalService() {
		return offerLocalService;
	}

	/**
	 * Sets the offer local service.
	 *
	 * @param offerLocalService the offer local service
	 */
	public void setOfferLocalService(OfferLocalService offerLocalService) {
		this.offerLocalService = offerLocalService;
	}

	/**
	 * Gets the offer remote service.
	 *
	 * @return the offer remote service
	 */
	public OfferService getOfferService() {
		return offerService;
	}

	/**
	 * Sets the offer remote service.
	 *
	 * @param offerService the offer remote service
	 */
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	/**
	 * Gets the offer persistence.
	 *
	 * @return the offer persistence
	 */
	public OfferPersistence getOfferPersistence() {
		return offerPersistence;
	}

	/**
	 * Sets the offer persistence.
	 *
	 * @param offerPersistence the offer persistence
	 */
	public void setOfferPersistence(OfferPersistence offerPersistence) {
		this.offerPersistence = offerPersistence;
	}

	/**
	 * Gets the message local service.
	 *
	 * @return the message local service
	 */
	public MessageLocalService getMessageLocalService() {
		return messageLocalService;
	}

	/**
	 * Sets the message local service.
	 *
	 * @param messageLocalService the message local service
	 */
	public void setMessageLocalService(MessageLocalService messageLocalService) {
		this.messageLocalService = messageLocalService;
	}

	/**
	 * Gets the message remote service.
	 *
	 * @return the message remote service
	 */
	public MessageService getMessageService() {
		return messageService;
	}

	/**
	 * Sets the message remote service.
	 *
	 * @param messageService the message remote service
	 */
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	/**
	 * Gets the message persistence.
	 *
	 * @return the message persistence
	 */
	public MessagePersistence getMessagePersistence() {
		return messagePersistence;
	}

	/**
	 * Sets the message persistence.
	 *
	 * @param messagePersistence the message persistence
	 */
	public void setMessagePersistence(MessagePersistence messagePersistence) {
		this.messagePersistence = messagePersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = requestPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = RequestLocalService.class)
	protected RequestLocalService requestLocalService;
	@BeanReference(type = RequestService.class)
	protected RequestService requestService;
	@BeanReference(type = RequestPersistence.class)
	protected RequestPersistence requestPersistence;
	@BeanReference(type = OfferLocalService.class)
	protected OfferLocalService offerLocalService;
	@BeanReference(type = OfferService.class)
	protected OfferService offerService;
	@BeanReference(type = OfferPersistence.class)
	protected OfferPersistence offerPersistence;
	@BeanReference(type = MessageLocalService.class)
	protected MessageLocalService messageLocalService;
	@BeanReference(type = MessageService.class)
	protected MessageService messageService;
	@BeanReference(type = MessagePersistence.class)
	protected MessagePersistence messagePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}