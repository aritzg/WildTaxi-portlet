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
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author    Sareweb
 * @see       Message
 * @generated
 */
public class MessageWrapper implements Message {
	public MessageWrapper(Message message) {
		_message = message;
	}

	public long getPrimaryKey() {
		return _message.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_message.setPrimaryKey(pk);
	}

	public java.lang.String getUuid() {
		return _message.getUuid();
	}

	public void setUuid(java.lang.String uuid) {
		_message.setUuid(uuid);
	}

	public long getMessageId() {
		return _message.getMessageId();
	}

	public void setMessageId(long messageId) {
		_message.setMessageId(messageId);
	}

	public long getOfferId() {
		return _message.getOfferId();
	}

	public void setOfferId(long offerId) {
		_message.setOfferId(offerId);
	}

	public java.lang.String getMessage() {
		return _message.getMessage();
	}

	public void setMessage(java.lang.String message) {
		_message.setMessage(message);
	}

	public long getCompanyId() {
		return _message.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_message.setCompanyId(companyId);
	}

	public long getUserId() {
		return _message.getUserId();
	}

	public void setUserId(long userId) {
		_message.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _message.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_message.setUserUuid(userUuid);
	}

	public java.util.Date getCreateDate() {
		return _message.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_message.setCreateDate(createDate);
	}

	public net.sareweb.wildtaxi.model.Message toEscapedModel() {
		return _message.toEscapedModel();
	}

	public boolean isNew() {
		return _message.isNew();
	}

	public void setNew(boolean n) {
		_message.setNew(n);
	}

	public boolean isCachedModel() {
		return _message.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_message.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _message.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_message.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _message.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _message.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_message.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _message.clone();
	}

	public int compareTo(net.sareweb.wildtaxi.model.Message message) {
		return _message.compareTo(message);
	}

	public int hashCode() {
		return _message.hashCode();
	}

	public java.lang.String toString() {
		return _message.toString();
	}

	public java.lang.String toXmlString() {
		return _message.toXmlString();
	}

	public Message getWrappedMessage() {
		return _message;
	}

	private Message _message;
}