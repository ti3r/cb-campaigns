package org.caringbridge.services;

import org.caringbridge.services.config.AppConfigTest
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.servlet.config.annotation.EnableWebMvc

import spock.lang.Specification

@SpringApplicationConfiguration(classes = AppConfigTest.class)
@WebIntegrationTest(randomPort = true)
@EnableWebMvc
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
class CBServicesBaseTest extends Specification {

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
