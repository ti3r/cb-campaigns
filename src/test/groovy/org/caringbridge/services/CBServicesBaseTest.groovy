package org.caringbridge.services;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spock.lang.AutoCleanup;
import spock.lang.Shared;
import spock.lang.Specification;

class CBServicesBaseTest extends Specification {

    @Shared
    @AutoCleanup
    public ConfigurableApplicationContext context;

    @Shared
    public MockMvc mvc;

    void setupSpec() throws Exception {
	// Create an application context based on the
	// SpringBootSpockTestApplication
	// class containing the app configuration. It is created in a Future
	// object
	// In order to wait only 60 seconds for the context to come up or fail
	Future<ConfigurableApplicationContext> future = Executors.newSingleThreadExecutor()
		.submit(new Callable<ConfigurableApplicationContext>() {
		    @Override
		    public ConfigurableApplicationContext call() throws Exception {
			return (ConfigurableApplicationContext) SpringApplication.run(CbMicroServicesApplication.class);
		    }
		});
	context = future.get(60, TimeUnit.SECONDS);
	mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    void"Check context build"()

    {
		when:
			Object o = new Object()
		then:
			o != null
	}

}
