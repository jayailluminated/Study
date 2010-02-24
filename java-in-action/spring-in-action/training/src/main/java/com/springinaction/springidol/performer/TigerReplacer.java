package com.springinaction.springidol.performer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 24, 2010
 * Time: 1:28:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class TigerReplacer implements MethodReplacer {
	public Object reimplement (Object target, Method method, Object[] args) throws Throwable {

		return "A ferocious tiger";
	}
}
