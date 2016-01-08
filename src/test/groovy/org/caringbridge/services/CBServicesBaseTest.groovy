package org.caringbridge.services;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.caringbridge.services.config.AppConfigTest;

import spock.lang.Specification;



/**
 * Abstract class that will serve as base for all the
 * spock integration tests of the project.
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@SpringApplicationConfiguration(classes = AppConfigTest.class)
@WebIntegrationTest(randomPort = true)
@EnableWebMvc
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ActiveProfiles("integration-tests")
abstract class CBServicesBaseTest extends Specification {

    //@Shared
    //@AutoCleanup
    @Autowired
    public ConfigurableApplicationContext context;
    public MockMvc mvc;
    
    @Before
    public void init() throws Exception{
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
