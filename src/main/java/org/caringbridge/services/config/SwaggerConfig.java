package org.caringbridge.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Class to configure behavior of spring-swagger component. This class will
 * contain the swagger top level definitions for the api.
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@Configuration
@EnableSwagger
@ComponentScan(basePackages = "org.caringbridge")
@EnableConfigurationProperties
public class SwaggerConfig {

    /**
     * The configurable property that will contain the Title Of The Swagger Api
     * Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.title}")
    private String swaggerApiTitle;
    /**
     * The configurable property that will contain the Description Of The Swagger Api
     * Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.description}")
    private String swaggerApiDescription;
    /**
     * The configurable property that will contain the Terms of Service Location 
     * Of The Swagger Api Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.termslocation}")
    private String swaggerApiTermsLocation;
    /**
     * The configurable property that will contain the contact email Of The 
     * Swagger Api Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.contact}")
    private String swaggerApiContact;
    /**
     * The configurable property that will contain the license type Of 
     * The Swagger Api Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.license.type}")
    private String swaggerApiLicenseName;
    /**
     * The configurable property that will contain the license url Of 
     * The Swagger Api Documentation.
     */
    @Value(value = "${org.caringbridge.services.swagger.license.url}")
    private String swaggerApiLicenseUrl;

    /**
     * The configurable property that will contain the license version Of 
     * The Api.
     */
    @Value(value = "${org.caringbridge.services.version}")
    private String apiVersion;
    /**
     * Creates the Spring Bean that will configure the Swagger top level documentation.
     * @param springSwaggerConfig SpringSwaggerConfig where to inject the top level
     * documentation
     * @return SwaggerSpringMvcPlugin that will drive the swagger configuration
     */
    @Bean
    public SwaggerSpringMvcPlugin createTopLevelSwaggerDocumentation(SpringSwaggerConfig springSwaggerConfig) {
	return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/.*")
		.apiVersion("2.0");

    }
    /**
     * Creates the ApiInfo object with the information for swagger.
     * @return ApiInfo object with the details.
     */
    public ApiInfo apiInfo() {
	ApiInfo api = new ApiInfo(swaggerApiTitle, swaggerApiDescription, swaggerApiTermsLocation, swaggerApiContact,
		swaggerApiLicenseName, swaggerApiLicenseUrl);
	return api;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	messageSource.setBasename("i18n/messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
    }
    
}
