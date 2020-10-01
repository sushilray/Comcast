package com.comcast.ucsi.validation.service.rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;



/**
 * ErrorMessageLoader responsible for loading error messages key based
 * 
 * @author Tarek Shalaby
 *
 */
@Component
public class ErrorMessageLoader implements IErrorMessageLoader{
	
	
	private volatile static ErrorMessageLoader instance=new ErrorMessageLoader();
	
	private Properties properties=null;
	
	static {
		
			
		
	}
	
	private ErrorMessageLoader() {
		
		loadAppliactionProperties();
	}
	
	
	


	public static synchronized IErrorMessageLoader getInstance() {
		
		if(instance==null) {
			
			synchronized (ErrorMessageLoader.class) {
				if(instance==null) {
					instance=new ErrorMessageLoader();
				}
			}
			
			
		}
		return ErrorMessageLoader.instance;
	}


	@Override
	public String getValue(String key) {
		
		return properties.getProperty(key);
		
	}
	
	private void loadAppliactionProperties() {
		//ToDo load application.properties all keys and values
		
		
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		properties = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream("validation.properties")) {
		    properties.load(resourceStream);
		} catch (IOException e) {
			
			throw new RuntimeException("Configuration error application.properties file missing");
		    
		}
		
		
		
	}
	

}
