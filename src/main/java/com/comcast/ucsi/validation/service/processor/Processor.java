package com.comcast.ucsi.validation.service.processor;

import java.io.InputStream;



/**
 * 
 * Processor is the main entry point of execution
 * 
 * 
 * @author Tarek Shalaby
 *
 */
public interface Processor {
	
	public Object process(InputStream dataStream);
	public Object HandleGloableError(String errorMessage);

}
