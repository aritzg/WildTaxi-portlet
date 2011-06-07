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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Sareweb
 */
public class RequestClp extends BaseModelImpl<Request> implements Request {
	public RequestClp() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_requestId);
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public Request toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Request)Proxy.newProxyInstance(Request.class.getClassLoader(),
				new Class[] { Request.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		RequestClp clone = new RequestClp();

		clone.setUuid(getUuid());
		clone.setRequestId(getRequestId());
		clone.setName(getName());
		clone.setFromLat(getFromLat());
		clone.setFromLng(getFromLng());
		clone.setFromAddress(getFromAddress());
		clone.setToLat(getToLat());
		clone.setToLng(getToLng());
		clone.setToAddress(getToAddress());
		clone.setDistance(getDistance());
		clone.setBeginDate(getBeginDate());
		clone.setDuration(getDuration());
		clone.setState(getState());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(Request request) {
		long pk = request.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RequestClp request = null;

		try {
			request = (RequestClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = request.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", fromLat=");
		sb.append(getFromLat());
		sb.append(", fromLng=");
		sb.append(getFromLng());
		sb.append(", fromAddress=");
		sb.append(getFromAddress());
		sb.append(", toLat=");
		sb.append(getToLat());
		sb.append(", toLng=");
		sb.append(getToLng());
		sb.append(", toAddress=");
		sb.append(getToAddress());
		sb.append(", distance=");
		sb.append(getDistance());
		sb.append(", beginDate=");
		sb.append(getBeginDate());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.wildtaxi.model.Request");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromLat</column-name><column-value><![CDATA[");
		sb.append(getFromLat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromLng</column-name><column-value><![CDATA[");
		sb.append(getFromLng());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromAddress</column-name><column-value><![CDATA[");
		sb.append(getFromAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toLat</column-name><column-value><![CDATA[");
		sb.append(getToLat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toLng</column-name><column-value><![CDATA[");
		sb.append(getToLng());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toAddress</column-name><column-value><![CDATA[");
		sb.append(getToAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distance</column-name><column-value><![CDATA[");
		sb.append(getDistance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginDate</column-name><column-value><![CDATA[");
		sb.append(getBeginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
}