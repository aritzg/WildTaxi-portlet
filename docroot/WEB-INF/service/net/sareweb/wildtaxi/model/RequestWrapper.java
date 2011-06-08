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

/**
 * <p>
 * This class is a wrapper for {@link Request}.
 * </p>
 *
 * @author    Sareweb
 * @see       Request
 * @generated
 */
public class RequestWrapper implements Request {
	public RequestWrapper(Request request) {
		_request = request;
	}

	public long getPrimaryKey() {
		return _request.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_request.setPrimaryKey(pk);
	}

	public java.lang.String getUuid() {
		return _request.getUuid();
	}

	public void setUuid(java.lang.String uuid) {
		_request.setUuid(uuid);
	}

	public long getRequestId() {
		return _request.getRequestId();
	}

	public void setRequestId(long requestId) {
		_request.setRequestId(requestId);
	}

	public java.lang.String getName() {
		return _request.getName();
	}

	public void setName(java.lang.String name) {
		_request.setName(name);
	}

	public float getFromLat() {
		return _request.getFromLat();
	}

	public void setFromLat(float fromLat) {
		_request.setFromLat(fromLat);
	}

	public float getFromLng() {
		return _request.getFromLng();
	}

	public void setFromLng(float fromLng) {
		_request.setFromLng(fromLng);
	}

	public java.lang.String getFromAddress() {
		return _request.getFromAddress();
	}

	public void setFromAddress(java.lang.String fromAddress) {
		_request.setFromAddress(fromAddress);
	}

	public float getToLat() {
		return _request.getToLat();
	}

	public void setToLat(float toLat) {
		_request.setToLat(toLat);
	}

	public float getToLng() {
		return _request.getToLng();
	}

	public void setToLng(float toLng) {
		_request.setToLng(toLng);
	}

	public java.lang.String getToAddress() {
		return _request.getToAddress();
	}

	public void setToAddress(java.lang.String toAddress) {
		_request.setToAddress(toAddress);
	}

	public long getDistance() {
		return _request.getDistance();
	}

	public void setDistance(long distance) {
		_request.setDistance(distance);
	}

	public java.util.Date getBeginDate() {
		return _request.getBeginDate();
	}

	public void setBeginDate(java.util.Date beginDate) {
		_request.setBeginDate(beginDate);
	}

	public java.lang.Integer getDuration() {
		return _request.getDuration();
	}

	public void setDuration(java.lang.Integer duration) {
		_request.setDuration(duration);
	}

	public java.lang.String getState() {
		return _request.getState();
	}

	public void setState(java.lang.String state) {
		_request.setState(state);
	}

	public long getCompanyId() {
		return _request.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_request.setCompanyId(companyId);
	}

	public long getUserId() {
		return _request.getUserId();
	}

	public void setUserId(long userId) {
		_request.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _request.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_request.setUserUuid(userUuid);
	}

	public java.util.Date getCreateDate() {
		return _request.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_request.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _request.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_request.setModifiedDate(modifiedDate);
	}

	public net.sareweb.wildtaxi.model.Request toEscapedModel() {
		return _request.toEscapedModel();
	}

	public boolean isNew() {
		return _request.isNew();
	}

	public void setNew(boolean n) {
		_request.setNew(n);
	}

	public boolean isCachedModel() {
		return _request.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_request.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _request.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_request.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _request.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _request.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_request.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _request.clone();
	}

	public int compareTo(net.sareweb.wildtaxi.model.Request request) {
		return _request.compareTo(request);
	}

	public int hashCode() {
		return _request.hashCode();
	}

	public java.lang.String toString() {
		return _request.toString();
	}

	public java.lang.String toXmlString() {
		return _request.toXmlString();
	}

	public Request getWrappedRequest() {
		return _request;
	}

	private Request _request;
}