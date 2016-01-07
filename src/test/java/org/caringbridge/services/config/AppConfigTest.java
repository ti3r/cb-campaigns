package org.caringbridge.services.config;

import org.caringbridge.services.CbMicroServicesApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class for the integration test context. This class will be
 * loaded in the spock integration test in order to configure the test
 * ServletContext correctly in our test without running the default {@literal @}
 * SpringBootApplication annotated default class. This will allow us to create a
 * custom simulated app context in our integration tests
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@WebAppConfiguration
@EnableWebMvc
@EnableMongoRepositories
@ComponentScan(basePackageClasses = { CbMicroServicesApplication.class })
@EnableAutoConfiguration
public class AppConfigTest {

}
