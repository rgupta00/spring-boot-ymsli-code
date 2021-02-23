package com.bookapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("i can define bean for web app context");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("i can define bean for root app context");
		return new Class[] { ModelConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
