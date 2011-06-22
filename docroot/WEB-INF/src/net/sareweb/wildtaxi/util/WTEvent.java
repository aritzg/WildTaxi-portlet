package net.sareweb.wildtaxi.util;

import java.util.Date;

import net.sareweb.wildtaxi.model.Request;

import com.liferay.portal.model.User;

public class WTEvent {
	private String type;
	private Date time;
	private User u1;
	private User u2;
	private Request request;
	
	

	public WTEvent(String type, Date time, User u1, User u2, Request request){
		this.type = type;
		this.time = time;
		this.u1 = u1;
		this.u2 = u2;
		this.request = request;
	}
	
	
	
	
	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Date getTime() {
		return time;
	}




	public void setTime(Date time) {
		this.time = time;
	}




	public User getU1() {
		return u1;
	}




	public void setU1(User u1) {
		this.u1 = u1;
	}




	public User getU2() {
		return u2;
	}




	public void setU2(User u2) {
		this.u2 = u2;
	}




	public Request getRequest() {
		return request;
	}




	public void setRequest(Request request) {
		this.request = request;
	}




	public static final String TYPE_CREATED_REQUEST="TYPE_CREATED_REQUEST";
}
