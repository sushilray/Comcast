package com.comcast.ucsi.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.ucsi.validation.service.autofill.GeneratedFieldsAutoFiller;
import com.comcast.ucsi.validation.service.model.CreateIngestRequestWrapper;

@RestController
public class Test383 {

	@Autowired
	GeneratedFieldsAutoFiller gnaf;

	@PostMapping("/test383")
	public Object test383(@RequestBody CreateIngestRequestWrapper data) {
		return gnaf.generateFields(data);

	}

}
