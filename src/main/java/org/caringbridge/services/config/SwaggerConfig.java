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

    @Value(value = "${org.caringbridge.services.swagger.title}")
    private String swaggerApiTitle;

    @Value(value = "${org.caringbridge.services.swagger.description}")
    private String swaggerApiDescription;

    @Value(value = "${org.caringbridge.services.swagger.termslocation}")
    private String swaggerApiTermsLocation;

    @Value(value = "${org.caringbridge.services.swagger.contact}")
    private String swaggerApiContact;

    @Value(value = "${org.caringbridge.services.swagger.license.type}")
    private String swaggerApiLicenseName;

    @Value(value = "${org.caringbridge.services.swagger.license.url}")
    private String swaggerApiLicenseUrl;

    @Bean
    public SwaggerSpringMvcPlugin createTopLevelSwaggerDocumentation(SpringSwaggerConfig springSwaggerConfig) {
	return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/.*")
		.apiVersion("2.0");

    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	messageSource.setBasename("i18n/messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
    }

    public ApiInfo apiInfo() {
	ApiInfo api = new ApiInfo(swaggerApiTitle, swaggerApiDescription, swaggerApiTermsLocation, swaggerApiContact,
		swaggerApiLicenseName, swaggerApiLicenseUrl);
	return api;
    }

}
