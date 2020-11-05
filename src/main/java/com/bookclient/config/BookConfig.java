package com.bookclient.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class BookConfig implements ServletContextAware {
	
	@Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = 
            new ServletRegistrationBean(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }
	
	@Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                    new ConfigureListener());
    }
	
	@Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter(
            "com.sun.faces.forceLoadConfiguration", 
            Boolean.TRUE.toString());
    }

}
