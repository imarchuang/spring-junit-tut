package com.kobo.spring.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.kobo.spring.junit.service.Order;
import com.kobo.spring.junit.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpringExample {

	@Autowired
	private SampleService sampleService;

	@Test
	public void testSampleService() {
		assertEquals("class com.kobo.spring.junit.service.SampleServiceImpl",
				this.sampleService.getClass().toString());
	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		// Check if the return description has a Description: string.
		assertTrue(sampleService.getOrderDescription().contains("Description:"));
	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a Code: string.
		assertTrue(sampleService.getOrderStringCode().contains("Code:"));
	}

	@Test
	public void testSampleServiceCreateNewOrder() {
		Order newOrder = new Order();
		newOrder.setSecurityCode("XYZ");
		newOrder.setDescription("Description");
		if (newOrder != null) {
			assertThat(sampleService.createOrder(newOrder), instanceOf(Order.class));
			assertNotNull("Security isn't null", newOrder.getSecurityCode());
			assertNotNull("Description isn't not null", newOrder.getDescription());
		}

		assertNotNull("New Order is not null", newOrder);

	}

	@Test
	public void testSampleServiceGetOrder() {

		Order existingOrder = sampleService.getOrder(0);

		if (existingOrder != null) {
			assertThat(sampleService.getOrder(0), instanceOf(Order.class));
			assertNotNull("Security isn't null", existingOrder.getSecurityCode());
			assertNotNull("Description isn't null", existingOrder.getDescription());
		}

		assertNotNull("Object is not null", existingOrder);
	}

}
