package net.sareweb.wildtaxi.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.sareweb.wildtaxi.model.Request;

import com.liferay.portal.model.User;

public class WTEventHandler {
	private ConcurrentLinkedQueue<WTEvent> events;

	protected WTEventHandler() {
		events = new ConcurrentLinkedQueue<WTEvent>();
	}

	static public WTEventHandler getInstance() {
		if (null == _instance) {
			_instance = new WTEventHandler();
		}
		return _instance;
	}

	public void addEvent(WTEvent event){
		events.add(event);
		if(events.size()>MAX_SIZE)events.poll();
	}
	
	public void addEvent(String type, Date time, User u1, User u2, Request request){
		WTEvent wte = new WTEvent(type, time, u1, u2, request);
		events.add(wte);
	}
	
	public List getEvents(long time){
		Iterator<WTEvent> eventsTmp = events.iterator();
		Vector<WTEvent> newerEvents = new Vector();
		while (eventsTmp.hasNext()) {
			WTEvent e = eventsTmp.next();
			if(e.getTime().getTime() > time){
				newerEvents.add(e);
			}
		}
		return newerEvents;
	}
	
	static private WTEventHandler _instance = null;
	static private int MAX_SIZE = 20;

}
