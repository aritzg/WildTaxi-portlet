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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link net.sareweb.wildtaxi.service.http.MessageServiceSoap}.
 * </p>
 *
 * @author    Sareweb
 * @see       net.sareweb.wildtaxi.service.http.MessageServiceSoap
 * @generated
 */
public class MessageSoap implements Serializable {
	public static MessageSoap toSoapModel(Message model) {
		MessageSoap soapModel = new MessageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setOfferId(model.getOfferId());
		soapModel.setMessage(model.getMessage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static MessageSoap[] toSoapModels(Message[] models) {
		MessageSoap[] soapModels = new MessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[][] toSoapModels(Message[][] models) {
		MessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[] toSoapModels(List<Message> models) {
		List<MessageSoap> soapModels = new ArrayList<MessageSoap>(models.size());

		for (Message model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MessageSoap[soapModels.size()]);
	}

	public MessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private String _uuid;
	private long _messageId;
	private long _offerId;
	private String _message;
	private long _companyId;
	private long _userId;
	private Date _createDate;
}