package com.springinaction.propeditor;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 27, 2010
 * Time: 8:30:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneEditor extends PropertyEditorSupport {
	public void setAsText(String textValue) {
		String stripped = stripNonNumeric(textValue);
		String areaCode = stripped.substring(0,3);
		String prefix = stripped.substring(3,6);
		String number = stripped.substring(6);
		PhoneNumber phone = new PhoneNumber(areaCode,prefix,number);
		setValue(phone);
	}

	private String stripNonNumeric (String original) {
		StringBuffer allNumeric = new StringBuffer();

		for (int i=0; i<original.length(); i++) {
			char c = original.charAt(i);
			if(Character.isDigit(c)){
				allNumeric.append(c);
			}
		}
		return allNumeric.toString();
	}
}
