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

package net.sareweb.wildtaxi.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import net.sareweb.wildtaxi.model.MessageClp;
import net.sareweb.wildtaxi.model.OfferClp;
import net.sareweb.wildtaxi.model.RequestClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "WildTaxi-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(RequestClp.class.getName())) {
			RequestClp oldCplModel = (RequestClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("net.sareweb.wildtaxi.model.impl.RequestImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUuid",
							new Class[] { String.class });

					String value0 = oldCplModel.getUuid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRequestId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getRequestId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFromLat",
							new Class[] { Float.TYPE });

					Float value3 = new Float(oldCplModel.getFromLat());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setFromLng",
							new Class[] { Float.TYPE });

					Float value4 = new Float(oldCplModel.getFromLng());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setFromAddress",
							new Class[] { String.class });

					String value5 = oldCplModel.getFromAddress();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setToLat",
							new Class[] { Float.TYPE });

					Float value6 = new Float(oldCplModel.getToLat());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setToLng",
							new Class[] { Float.TYPE });

					Float value7 = new Float(oldCplModel.getToLng());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setToAddress",
							new Class[] { String.class });

					String value8 = oldCplModel.getToAddress();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setDistance",
							new Class[] { Long.TYPE });

					Long value9 = new Long(oldCplModel.getDistance());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setBeginDate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getBeginDate();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setDuration",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getDuration());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setState",
							new Class[] { String.class });

					String value12 = oldCplModel.getState();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value13 = new Long(oldCplModel.getCompanyId());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value14 = new Long(oldCplModel.getUserId());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getCreateDate();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getModifiedDate();

					method16.invoke(newModel, value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OfferClp.class.getName())) {
			OfferClp oldCplModel = (OfferClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("net.sareweb.wildtaxi.model.impl.OfferImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUuid",
							new Class[] { String.class });

					String value0 = oldCplModel.getUuid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOfferId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getOfferId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getRequestId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setState",
							new Class[] { String.class });

					String value3 = oldCplModel.getState();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAgreementKey",
							new Class[] { String.class });

					String value4 = oldCplModel.getAgreementKey();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getCompanyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getUserId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCreateDate();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(MessageClp.class.getName())) {
			MessageClp oldCplModel = (MessageClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("net.sareweb.wildtaxi.model.impl.MessageImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUuid",
							new Class[] { String.class });

					String value0 = oldCplModel.getUuid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMessageId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getMessageId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOfferId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getOfferId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setMessage",
							new Class[] { String.class });

					String value3 = oldCplModel.getMessage();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCompanyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreateDate();

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"net.sareweb.wildtaxi.model.impl.RequestImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					RequestClp newModel = new RequestClp();

					Method method0 = oldModelClass.getMethod("getUuid");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUuid(value0);

					Method method1 = oldModelClass.getMethod("getRequestId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setRequestId(value1);

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getFromLat");

					Float value3 = (Float)method3.invoke(oldModel,
							(Object[])null);

					newModel.setFromLat(value3);

					Method method4 = oldModelClass.getMethod("getFromLng");

					Float value4 = (Float)method4.invoke(oldModel,
							(Object[])null);

					newModel.setFromLng(value4);

					Method method5 = oldModelClass.getMethod("getFromAddress");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setFromAddress(value5);

					Method method6 = oldModelClass.getMethod("getToLat");

					Float value6 = (Float)method6.invoke(oldModel,
							(Object[])null);

					newModel.setToLat(value6);

					Method method7 = oldModelClass.getMethod("getToLng");

					Float value7 = (Float)method7.invoke(oldModel,
							(Object[])null);

					newModel.setToLng(value7);

					Method method8 = oldModelClass.getMethod("getToAddress");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setToAddress(value8);

					Method method9 = oldModelClass.getMethod("getDistance");

					Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

					newModel.setDistance(value9);

					Method method10 = oldModelClass.getMethod("getBeginDate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setBeginDate(value10);

					Method method11 = oldModelClass.getMethod("getDuration");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setDuration(value11);

					Method method12 = oldModelClass.getMethod("getState");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setState(value12);

					Method method13 = oldModelClass.getMethod("getCompanyId");

					Long value13 = (Long)method13.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value13);

					Method method14 = oldModelClass.getMethod("getUserId");

					Long value14 = (Long)method14.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value14);

					Method method15 = oldModelClass.getMethod("getCreateDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setCreateDate(value15);

					Method method16 = oldModelClass.getMethod("getModifiedDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"net.sareweb.wildtaxi.model.impl.OfferImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OfferClp newModel = new OfferClp();

					Method method0 = oldModelClass.getMethod("getUuid");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUuid(value0);

					Method method1 = oldModelClass.getMethod("getOfferId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setOfferId(value1);

					Method method2 = oldModelClass.getMethod("getRequestId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setRequestId(value2);

					Method method3 = oldModelClass.getMethod("getState");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setState(value3);

					Method method4 = oldModelClass.getMethod("getAgreementKey");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAgreementKey(value4);

					Method method5 = oldModelClass.getMethod("getCompanyId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value5);

					Method method6 = oldModelClass.getMethod("getUserId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setUserId(value6);

					Method method7 = oldModelClass.getMethod("getCreateDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"net.sareweb.wildtaxi.model.impl.MessageImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					MessageClp newModel = new MessageClp();

					Method method0 = oldModelClass.getMethod("getUuid");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUuid(value0);

					Method method1 = oldModelClass.getMethod("getMessageId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setMessageId(value1);

					Method method2 = oldModelClass.getMethod("getOfferId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setOfferId(value2);

					Method method3 = oldModelClass.getMethod("getMessage");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setMessage(value3);

					Method method4 = oldModelClass.getMethod("getCompanyId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value4);

					Method method5 = oldModelClass.getMethod("getUserId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setUserId(value5);

					Method method6 = oldModelClass.getMethod("getCreateDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}