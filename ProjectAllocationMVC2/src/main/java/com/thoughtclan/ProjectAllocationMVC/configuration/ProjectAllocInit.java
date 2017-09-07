package com.thoughtclan.ProjectAllocationMVC.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ProjectAllocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
	@Override
   protected Class<?>[] getRootConfigClasses() {
       return new Class[] { ProjectAllocConfiguration.class };
   }
 
   @Override
   protected Class<?>[] getServletConfigClasses() {
       return null;
   }
 
   @Override
   protected String[] getServletMappings() {
       return new String[] { "/" };
   }
}
