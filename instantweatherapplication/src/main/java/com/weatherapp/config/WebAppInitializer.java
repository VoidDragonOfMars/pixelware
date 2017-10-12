package com.weatherapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Inicializador de la app web
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * Clases de configracion de componentes NO web
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{};
	}
	/*
	 * Clases de configracion de componentes WEB
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// es la clase de configuracion que me he creado antes
		return new Class<?>[]{WebConfig.class};
	}

	/*
	 * Patrones de llamada a DispatcherServlet de SpringMVC
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
