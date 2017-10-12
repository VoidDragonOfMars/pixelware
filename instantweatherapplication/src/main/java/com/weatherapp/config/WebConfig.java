package com.weatherapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;




@Configuration

@EnableWebMvc

@ComponentScan(basePackages = { "com.weatherapp.controller", "com.weatherapp.model.*", "com.weatherapp.services","com.weatherapp.exceptions","com.weatherapp.validators"})
@PropertySource(value = { "classpath:application.properties" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	
	/*
	 * Devolución de un bean (componente) para gestion de vistas
	 */
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
	
	
	@Bean
	public MessageSource messageSource() {
		// Crear paquete de recursos
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		
		// Cargar paquete
		source.setBasename("errores");
		
		return source;
	}
	
	
	
	@Bean(name="dataSource")
    public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        
        System.out.println(env.getRequiredProperty("jdbc.driverClassName"));
        System.out.println(env.getRequiredProperty("jdbc.username"));
        System.out.println(env.getRequiredProperty("jdbc.password"));
        System.out.println(env.getRequiredProperty("jdbc.url"));
        return dataSource;

    }
	

}

