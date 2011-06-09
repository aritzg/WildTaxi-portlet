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
 * {@link net.sareweb.wildtaxi.service.http.OfferServiceSoap}.
 * </p>
 *
 * @author    Sareweb
 * @see       net.sareweb.wildtaxi.service.http.OfferServiceSoap
 * @generated
 */
public class OfferSoap implements Serializable {
	public static OfferSoap toSoapModel(Offer model) {
		OfferSoap soapModel = new OfferSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setOfferId(model.getOfferId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setState(model.getState());
		soapModel.setAgreementKey(model.getAgreementKey());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static OfferSoap[] toSoapModels(Offer[] models) {
		OfferSoap[] soapModels = new OfferSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfferSoap[][] toSoapModels(Offer[][] models) {
		OfferSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfferSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfferSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfferSoap[] toSoapModels(List<Offer> models) {
		List<OfferSoap> soapModels = new ArrayList<OfferSoap>(models.size());

		for (Offer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfferSoap[soapModels.size()]);
	}

	public OfferSoap() {
	}

	public long getPrimaryKey() {
		return _offerId;
	}

	public void setPrimaryKey(long pk) {
		setOfferId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getAgreementKey() {
		return _agreementKey;
	}

	public void setAgreementKey(String agreementKey) {
		_agreementKey = agreementKey;
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
	private long _offerId;
	private long _requestId;
	private String _state;
	private String _agreementKey;
	private long _companyId;
	private long _userId;
	private Date _createDate;
}