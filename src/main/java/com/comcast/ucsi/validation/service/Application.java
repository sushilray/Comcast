package com.comcast.ucsi.validation.service;

import java.io.InputStream;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.comcast.ucsi.validation.service.processor.Processor;

@SpringBootApplication
@ComponentScan(basePackages = "com.comcast.ucsi.validation")
public class Application {

	@Autowired
	private Processor processor;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Function<InputStream, Object> ValidationServiceProcessorAdapter() {
		return value -> {

			try {
				return processor.process(value);
			} catch (Exception e) {

				// ToDO send the Exception object to the HandleGloableError method
				return processor.HandleGloableError(e.getMessage());
			}

		};
	}

}
