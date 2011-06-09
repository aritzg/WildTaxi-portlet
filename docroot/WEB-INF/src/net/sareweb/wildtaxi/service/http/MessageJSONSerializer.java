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

import net.sareweb.wildtaxi.model.Message;

import java.util.Date;
import java.util.List;

/**
 * @author    Sareweb
 * @generated
 */
public class MessageJSONSerializer {
	public static JSONObject toJSONObject(Message model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("uuid", model.getUuid());
		jsonObj.put("messageId", model.getMessageId());
		jsonObj.put("offerId", model.getOfferId());
		jsonObj.put("message", model.getMessage());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("userId", model.getUserId());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObj.put("createDate", createDateJSON);

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		net.sareweb.wildtaxi.model.Message[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Message model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		net.sareweb.wildtaxi.model.Message[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Message[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<net.sareweb.wildtaxi.model.Message> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Message model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}