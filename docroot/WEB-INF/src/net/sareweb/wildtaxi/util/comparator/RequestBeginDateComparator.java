package net.sareweb.wildtaxi.util.comparator;

import net.sareweb.wildtaxi.model.Request;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class RequestBeginDateComparator extends OrderByComparator {
	
	public static String ORDER_BY_ASC = "beginDate ASC";
	public static String ORDER_BY_DESC = "beginDate DESC";
	
	public static String[] ORDER_BY_FIELDS = {"beginDate"};
	
	public RequestBeginDateComparator() {
		this(false);
	}
	
	public RequestBeginDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	public int compare(Object obj1, Object obj2) {
		Request req1 = (Request)obj1;
		Request req2 = (Request)obj2;

		int value = DateUtil.compareTo(
			req1.getCreateDate(), req2.getCreateDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}
	
	
	private boolean _ascending;

}
