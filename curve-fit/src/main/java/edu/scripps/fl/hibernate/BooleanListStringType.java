/**
 * 
 */
package edu.scripps.fl.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.list.GrowthList;

public class BooleanListStringType extends ListStringType<Boolean> {

	public List<Boolean> getListFromString(String list) {
		List<Boolean> ids = newList(list.length());
		for (int ii = 0; ii < list.length(); ii++) {
			Boolean bool = null;
			if( '0' == list.charAt(ii) )
				bool = Boolean.FALSE;
			else if( '1' == list.charAt(ii) )
				bool = Boolean.TRUE;
			else
				bool = null;
			ids.set(ii, bool);
		}
		return ids;
	}

	public String getStringFromList(List<Boolean> ids) {
		if (null == ids)
			return null;
		StringBuffer sb = new StringBuffer();
		for(Boolean bool: ids) {
			if( bool == null )
				sb.append(' ');
			else if ( Boolean.TRUE.equals(bool) )
				sb.append('1');
			else
				sb.append('0');
		}
		return sb.toString();
	}
	
	public List<Boolean> newList(int initialCapacity) {
		return (List<Boolean>) GrowthList.decorate(new ArrayList<Boolean>(initialCapacity));
	}	
}