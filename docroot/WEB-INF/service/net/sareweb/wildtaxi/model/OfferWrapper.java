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
 * This class is a wrapper for {@link Offer}.
 * </p>
 *
 * @author    Sareweb
 * @see       Offer
 * @generated
 */
public class OfferWrapper implements Offer {
	public OfferWrapper(Offer offer) {
		_offer = offer;
	}

	public long getPrimaryKey() {
		return _offer.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_offer.setPrimaryKey(pk);
	}

	public java.lang.String getUuid() {
		return _offer.getUuid();
	}

	public void setUuid(java.lang.String uuid) {
		_offer.setUuid(uuid);
	}

	public long getOfferId() {
		return _offer.getOfferId();
	}

	public void setOfferId(long offerId) {
		_offer.setOfferId(offerId);
	}

	public long getRequestId() {
		return _offer.getRequestId();
	}

	public void setRequestId(long requestId) {
		_offer.setRequestId(requestId);
	}

	public java.lang.String getState() {
		return _offer.getState();
	}

	public void setState(java.lang.String state) {
		_offer.setState(state);
	}

	public java.lang.String getAgreementKey() {
		return _offer.getAgreementKey();
	}

	public void setAgreementKey(java.lang.String agreementKey) {
		_offer.setAgreementKey(agreementKey);
	}

	public long getCompanyId() {
		return _offer.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_offer.setCompanyId(companyId);
	}

	public long getUserId() {
		return _offer.getUserId();
	}

	public void setUserId(long userId) {
		_offer.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _offer.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_offer.setUserUuid(userUuid);
	}

	public java.util.Date getCreateDate() {
		return _offer.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_offer.setCreateDate(createDate);
	}

	public net.sareweb.wildtaxi.model.Offer toEscapedModel() {
		return _offer.toEscapedModel();
	}

	public boolean isNew() {
		return _offer.isNew();
	}

	public void setNew(boolean n) {
		_offer.setNew(n);
	}

	public boolean isCachedModel() {
		return _offer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_offer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _offer.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_offer.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _offer.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _offer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_offer.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _offer.clone();
	}

	public int compareTo(net.sareweb.wildtaxi.model.Offer offer) {
		return _offer.compareTo(offer);
	}

	public int hashCode() {
		return _offer.hashCode();
	}

	public java.lang.String toString() {
		return _offer.toString();
	}

	public java.lang.String toXmlString() {
		return _offer.toXmlString();
	}

	public Offer getWrappedOffer() {
		return _offer;
	}

	private Offer _offer;
}