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

package net.sareweb.wildtaxi.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import net.sareweb.wildtaxi.model.Request;

import java.util.Date;
import java.util.List;

/**
 * @author    Sareweb
 * @generated
 */
public class RequestJSONSerializer {
	public static JSONObject toJSONObject(Request model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("uuid", model.getUuid());
		jsonObj.put("requestId", model.getRequestId());
		jsonObj.put("name", model.getName());
		jsonObj.put("fromLat", model.getFromLat());
		jsonObj.put("fromLng", model.getFromLng());
		jsonObj.put("fromAddress", model.getFromAddress());
		jsonObj.put("toLat", model.getToLat());
		jsonObj.put("toLng", model.getToLng());
		jsonObj.put("toAddress", model.getToAddress());
		jsonObj.put("distance", model.getDistance());

		Date beginDate = model.getBeginDate();

		String beginDateJSON = StringPool.BLANK;

		if (beginDate != null) {
			beginDateJSON = String.valueOf(beginDate.getTime());
		}

		jsonObj.put("beginDate", beginDateJSON);
		jsonObj.put("duration", model.getDuration());
		jsonObj.put("state", model.getState());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("userId", model.getUserId());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObj.put("createDate", createDateJSON);

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObj.put("modifiedDate", modifiedDateJSON);

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		net.sareweb.wildtaxi.model.Request[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Request model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		net.sareweb.wildtaxi.model.Request[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Request[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<net.sareweb.wildtaxi.model.Request> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Request model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}