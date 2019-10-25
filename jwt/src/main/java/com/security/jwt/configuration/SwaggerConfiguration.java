/**
 * 
 */
package com.security.jwt.configuration;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author alexsurya
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT = new Contact("Alex Surya", "alexsurya.com", "alexsuryaras@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("JWT", "JWT", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	
	 Parameter headerParam = new ParameterBuilder().name("Authorization").defaultValue("").parameterType("header")
             .modelRef(new ModelRef("Authorization")).description("Authorization").required(false).build();

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).globalOperationParameters(Arrays.asList(headerParam)).select()                                  
		          .apis(RequestHandlerSelectors.basePackage("com.security.jwt"))              
		          .paths(PathSelectors.any())                          
		          .build();
	}
		
}
