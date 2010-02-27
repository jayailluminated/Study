package com.springinaction.special;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * User: moretajoo
 * Date: Feb 27, 2010
 * Time: 11:25:36 PM
 */
public class Fuddifier implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization (Object bean, String name) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();

		try {
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getType().equals(java.lang.String.class)) {
					fields[i].setAccessible(true);
					String original = (String) fields[i].get(bean);
					fields[i].set(bean, fuddify(original));
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private String fuddify (String original) {
		if (original == null) return original;
		return original.replaceAll("(r|l)", "w").replaceAll("(R|L)", "W");
	}

	@Override
	public Object postProcessAfterInitialization (Object bean, String name) throws BeansException {
		return bean;
	}
}
