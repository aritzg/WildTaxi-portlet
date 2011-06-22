package net.sareweb.wildtaxi.util;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import net.sareweb.wildtaxi.model.Request;

import com.liferay.portal.model.User;

public class WTEventHandler {
	private List<WTEvent> events;

	protected WTEventHandler() {
		events = new Vector<WTEvent>();
	}

	static public WTEventHandler getInstance() {
		if (null == _instance) {
			_instance = new WTEventHandler();
		}
		return _instance;
	}

	public void addEvent(WTEvent event){
		events.add(event);
	}
	
	public void addEvent(String type, Date time, User u1, User u2, Request request){
		WTEvent wte = new WTEvent(type, time, u1, u2, request);
		events.add(wte);
	}
	
	public List getEvents(){
		return events;
	}
	
	static private WTEventHandler _instance = null;

}
