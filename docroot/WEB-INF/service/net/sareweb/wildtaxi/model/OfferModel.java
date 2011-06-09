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

package net.sareweb.wildtaxi.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Offer service. Represents a row in the &quot;wt_Offer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.wildtaxi.model.impl.OfferModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.wildtaxi.model.impl.OfferImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a offer model instance should use the {@link Offer} interface instead.
 * </p>
 *
 * @author Sareweb
 * @see Offer
 * @see net.sareweb.wildtaxi.model.impl.OfferImpl
 * @see net.sareweb.wildtaxi.model.impl.OfferModelImpl
 * @generated
 */
public interface OfferModel extends BaseModel<Offer> {
	/**
	 * Gets the primary key of this offer.
	 *
	 * @return the primary key of this offer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this offer
	 *
	 * @param pk the primary key of this offer
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this offer.
	 *
	 * @return the uuid of this offer
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this offer.
	 *
	 * @param uuid the uuid of this offer
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the offer id of this offer.
	 *
	 * @return the offer id of this offer
	 */
	public long getOfferId();

	/**
	 * Sets the offer id of this offer.
	 *
	 * @param offerId the offer id of this offer
	 */
	public void setOfferId(long offerId);

	/**
	 * Gets the request id of this offer.
	 *
	 * @return the request id of this offer
	 */
	public long getRequestId();

	/**
	 * Sets the request id of this offer.
	 *
	 * @param requestId the request id of this offer
	 */
	public void setRequestId(long requestId);

	/**
	 * Gets the state of this offer.
	 *
	 * @return the state of this offer
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this offer.
	 *
	 * @param state the state of this offer
	 */
	public void setState(String state);

	/**
	 * Gets the agreement key of this offer.
	 *
	 * @return the agreement key of this offer
	 */
	@AutoEscape
	public String getAgreementKey();

	/**
	 * Sets the agreement key of this offer.
	 *
	 * @param agreementKey the agreement key of this offer
	 */
	public void setAgreementKey(String agreementKey);

	/**
	 * Gets the company id of this offer.
	 *
	 * @return the company id of this offer
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this offer.
	 *
	 * @param companyId the company id of this offer
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this offer.
	 *
	 * @return the user id of this offer
	 */
	public long getUserId();

	/**
	 * Sets the user id of this offer.
	 *
	 * @param userId the user id of this offer
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this offer.
	 *
	 * @return the user uuid of this offer
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this offer.
	 *
	 * @param userUuid the user uuid of this offer
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the create date of this offer.
	 *
	 * @return the create date of this offer
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this offer.
	 *
	 * @param createDate the create date of this offer
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets a copy of this offer as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Offer toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Offer offer);

	public int hashCode();

	public String toString();

	public String toXmlString();
}