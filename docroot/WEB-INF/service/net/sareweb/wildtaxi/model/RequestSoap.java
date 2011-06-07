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
 * {@link net.sareweb.wildtaxi.service.http.RequestServiceSoap}.
 * </p>
 *
 * @author    Sareweb
 * @see       net.sareweb.wildtaxi.service.http.RequestServiceSoap
 * @generated
 */
public class RequestSoap implements Serializable {
	public static RequestSoap toSoapModel(Request model) {
		RequestSoap soapModel = new RequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setName(model.getName());
		soapModel.setFromLat(model.getFromLat());
		soapModel.setFromLng(model.getFromLng());
		soapModel.setFromAddress(model.getFromAddress());
		soapModel.setToLat(model.getToLat());
		soapModel.setToLng(model.getToLng());
		soapModel.setToAddress(model.getToAddress());
		soapModel.setDistance(model.getDistance());
		soapModel.setBeginDate(model.getBeginDate());
		soapModel.setDuration(model.getDuration());
		soapModel.setState(model.getState());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static RequestSoap[] toSoapModels(Request[] models) {
		RequestSoap[] soapModels = new RequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequestSoap[][] toSoapModels(Request[][] models) {
		RequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequestSoap[] toSoapModels(List<Request> models) {
		List<RequestSoap> soapModels = new ArrayList<RequestSoap>(models.size());

		for (Request model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequestSoap[soapModels.size()]);
	}

	public RequestSoap() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public float getFromLat() {
		return _fromLat;
	}

	public void setFromLat(float fromLat) {
		_fromLat = fromLat;
	}

	public float getFromLng() {
		return _fromLng;
	}

	public void setFromLng(float fromLng) {
		_fromLng = fromLng;
	}

	public String getFromAddress() {
		return _fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		_fromAddress = fromAddress;
	}

	public float getToLat() {
		return _toLat;
	}

	public void setToLat(float toLat) {
		_toLat = toLat;
	}

	public float getToLng() {
		return _toLng;
	}

	public void setToLng(float toLng) {
		_toLng = toLng;
	}

	public String getToAddress() {
		return _toAddress;
	}

	public void setToAddress(String toAddress) {
		_toAddress = toAddress;
	}

	public long getDistance() {
		return _distance;
	}

	public void setDistance(long distance) {
		_distance = distance;
	}

	public Date getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(Date beginDate) {
		_beginDate = beginDate;
	}

	public Integer getDuration() {
		return _duration;
	}

	public void setDuration(Integer duration) {
		_duration = duration;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _requestId;
	private String _name;
	private float _fromLat;
	private float _fromLng;
	private String _fromAddress;
	private float _toLat;
	private float _toLng;
	private String _toAddress;
	private long _distance;
	private Date _beginDate;
	private Integer _duration;
	private String _state;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}