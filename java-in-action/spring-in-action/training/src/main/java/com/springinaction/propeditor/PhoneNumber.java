package com.springinaction.propeditor;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 27, 2010
 * Time: 3:07:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneNumber {
	private String areaCode;
	private String prefix;
	private String number;

	public PhoneNumber (String areaCode, String prefix, String number) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.number = number;
	}

	public String getAreaCode () {
		return areaCode;
	}

	public String getPrefix () {
		return prefix;
	}

	public String getNumber () {
		return number;
	}
}
