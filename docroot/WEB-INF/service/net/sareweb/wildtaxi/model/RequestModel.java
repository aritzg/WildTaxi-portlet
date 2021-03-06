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
 * The base model interface for the Request service. Represents a row in the &quot;wt_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.wildtaxi.model.impl.RequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.wildtaxi.model.impl.RequestImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a request model instance should use the {@link Request} interface instead.
 * </p>
 *
 * @author Sareweb
 * @see Request
 * @see net.sareweb.wildtaxi.model.impl.RequestImpl
 * @see net.sareweb.wildtaxi.model.impl.RequestModelImpl
 * @generated
 */
public interface RequestModel extends BaseModel<Request> {
	/**
	 * Gets the primary key of this request.
	 *
	 * @return the primary key of this request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this request
	 *
	 * @param pk the primary key of this request
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this request.
	 *
	 * @return the uuid of this request
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this request.
	 *
	 * @param uuid the uuid of this request
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the request id of this request.
	 *
	 * @return the request id of this request
	 */
	public long getRequestId();

	/**
	 * Sets the request id of this request.
	 *
	 * @param requestId the request id of this request
	 */
	public void setRequestId(long requestId);

	/**
	 * Gets the name of this request.
	 *
	 * @return the name of this request
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this request.
	 *
	 * @param name the name of this request
	 */
	public void setName(String name);

	/**
	 * Gets the from lat of this request.
	 *
	 * @return the from lat of this request
	 */
	public float getFromLat();

	/**
	 * Sets the from lat of this request.
	 *
	 * @param fromLat the from lat of this request
	 */
	public void setFromLat(float fromLat);

	/**
	 * Gets the from lng of this request.
	 *
	 * @return the from lng of this request
	 */
	public float getFromLng();

	/**
	 * Sets the from lng of this request.
	 *
	 * @param fromLng the from lng of this request
	 */
	public void setFromLng(float fromLng);

	/**
	 * Gets the from address of this request.
	 *
	 * @return the from address of this request
	 */
	@AutoEscape
	public String getFromAddress();

	/**
	 * Sets the from address of this request.
	 *
	 * @param fromAddress the from address of this request
	 */
	public void setFromAddress(String fromAddress);

	/**
	 * Gets the to lat of this request.
	 *
	 * @return the to lat of this request
	 */
	public float getToLat();

	/**
	 * Sets the to lat of this request.
	 *
	 * @param toLat the to lat of this request
	 */
	public void setToLat(float toLat);

	/**
	 * Gets the to lng of this request.
	 *
	 * @return the to lng of this request
	 */
	public float getToLng();

	/**
	 * Sets the to lng of this request.
	 *
	 * @param toLng the to lng of this request
	 */
	public void setToLng(float toLng);

	/**
	 * Gets the to address of this request.
	 *
	 * @return the to address of this request
	 */
	@AutoEscape
	public String getToAddress();

	/**
	 * Sets the to address of this request.
	 *
	 * @param toAddress the to address of this request
	 */
	public void setToAddress(String toAddress);

	/**
	 * Gets the distance of this request.
	 *
	 * @return the distance of this request
	 */
	public long getDistance();

	/**
	 * Sets the distance of this request.
	 *
	 * @param distance the distance of this request
	 */
	public void setDistance(long distance);

	/**
	 * Gets the begin date of this request.
	 *
	 * @return the begin date of this request
	 */
	public Date getBeginDate();

	/**
	 * Sets the begin date of this request.
	 *
	 * @param beginDate the begin date of this request
	 */
	public void setBeginDate(Date beginDate);

	/**
	 * Gets the duration of this request.
	 *
	 * @return the duration of this request
	 */
	public Integer getDuration();

	/**
	 * Sets the duration of this request.
	 *
	 * @param duration the duration of this request
	 */
	public void setDuration(Integer duration);

	/**
	 * Gets the state of this request.
	 *
	 * @return the state of this request
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this request.
	 *
	 * @param state the state of this request
	 */
	public void setState(String state);

	/**
	 * Gets the company id of this request.
	 *
	 * @return the company id of this request
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this request.
	 *
	 * @param companyId the company id of this request
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this request.
	 *
	 * @return the user id of this request
	 */
	public long getUserId();

	/**
	 * Sets the user id of this request.
	 *
	 * @param userId the user id of this request
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this request.
	 *
	 * @return the user uuid of this request
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this request.
	 *
	 * @param userUuid the user uuid of this request
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the create date of this request.
	 *
	 * @return the create date of this request
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this request.
	 *
	 * @param createDate the create date of this request
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this request.
	 *
	 * @return the modified date of this request
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this request.
	 *
	 * @param modifiedDate the modified date of this request
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets a copy of this request as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Request toEscapedModel();

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

	public int compareTo(Request request);

	public int hashCode();

	public String toString();

	public String toXmlString();
}