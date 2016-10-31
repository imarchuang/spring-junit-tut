package com.kobo.spring.junit;

import org.springframework.context.annotation.Bean;

import com.kobo.spring.junit.service.SampleService;
import com.kobo.spring.junit.service.SampleServiceImpl;

public class AppConfig {
	@Bean
	public SampleService getSampleService() {
		return new SampleServiceImpl();
	}
}
