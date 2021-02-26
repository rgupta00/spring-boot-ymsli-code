package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
 * this is the replacement of web.xml
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	//this should be used for root app context
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("root app context scope");
		return new Class[] {SecCofig.class};
	}

	//this should be used for web app context
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("web app context scope");
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
