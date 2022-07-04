//package com.spring.config;
//
//import javax.servlet.ServletConfig;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class[] {RootConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class[] {ServletConfig.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] {"/"};
//	}
//	
//	//CORS
//	public void addCorsMapping(CorsRegistry registry) {
//		registry.addMapping("/**")
//		.allowedOrigins("http://localhost:3000")
//		.allowedMethods("GET")
//		.allowedMethods("POST");
//		
//	}
//}
