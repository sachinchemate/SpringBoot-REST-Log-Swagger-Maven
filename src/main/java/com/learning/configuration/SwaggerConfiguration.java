/**
 * 
 */
package com.learning.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.learning.model.Person;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SACHIN
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)  // for bean validation - check Person.java file
public class SwaggerConfiguration    
{
   /** @Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.learning")))
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build();
        // @formatter:on
    }**/
	
	 	@Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()
	          //.apis(RequestHandlerSelectors.any())
	          .apis(RequestHandlerSelectors.basePackage("com.learning"))
	          //.apis(Predicates.not(RequestHandlerSelectors.basePackage("com.learning")))
	          .paths(PathSelectors.any())
	          //.paths(PathSelectors.ant("/RestAPIDemo"))
	          .build()
	          .apiInfo(apiInfo());
	    }
    
	 	// Only required when not using spring-boot	 	
	   /* @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) 
	    {
	        //enabling swagger-ui part for visual documentation
	        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }*/

	 	
	 	private ApiInfo apiInfo() {
	 		
	 	    return new ApiInfo(
	 	      "My REST API Demo", 
	 	      "Some custom description of API.", 
	 	      "API TOS", 
	 	      "Terms of service", 
	 	      new Contact("Contact", "details","email@email.com"), 
	 	      "License of API", "API license URL", Collections.emptyList());
	 	}
}
