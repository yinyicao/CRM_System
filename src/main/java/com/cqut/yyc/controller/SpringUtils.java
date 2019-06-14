package com.cqut.yyc.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		if (SpringUtils.applicationContext == null) {
			SpringUtils.applicationContext = arg0;
		}
	}

	/**
	 * 
	 * @Title: getApplicationContext   
	 * @Description: TODO(获取applicationContext)   
	 * @param: @return      
	 * @return: ApplicationContext      
	 * @throws
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 
	 * @Title: getBean   
	 * @Description: TODO(通过name获取 Bean.)   
	 * @param: @param name
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 * 
	 * @Title: getBean   
	 * @Description: TODO(通过class获取Bean.)   
	 * @param: @param <T>
	 * @param: @param clazz
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	/**
	 * 
	 * @Title: getBean   
	 * @Description: TODO(通过name,以及Clazz返回指定的Bean)   
	 * @param: @param <T>
	 * @param: @param name
	 * @param: @param clazz
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

}