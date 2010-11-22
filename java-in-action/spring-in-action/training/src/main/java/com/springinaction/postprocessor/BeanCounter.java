package com.springinaction.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * User: moretajoo
 * Date: Feb 28, 2010
 * Time: 1:22:45 AM
 */
public class BeanCounter implements BeanFactoryPostProcessor{
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void postProcessBeanFactory (ConfigurableListableBeanFactory factory) throws BeansException {
		logger.info("BEAN COUNT {}", factory.getBeanDefinitionCount());
	}
}
