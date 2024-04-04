package com.example.jwt.byDurgesh.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;

import java.util.Arrays;
import java.util.Collections;

@Configuration

@OpenAPIDefinition
@SecurityScheme(name = "Authorization", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)

public class Swagger {

	@Bean
	public OpenAPI nexusOpenApi() {
		return new OpenAPI().info(new Info().title("JWT Token_With_Swagger")
				// .description(getDescription())
				// .version(getVersion())
				.license(new License().name("(C) Copyright xxx").url("http://www.example.com")))
				.security(Collections.singletonList(new SecurityRequirement().addList("Authorization")))
				.externalDocs(new ExternalDocumentation());
	}

	@Bean
	public GroupedOpenApi controllerApi() {
		return GroupedOpenApi.builder()

				.group("controller-api").packagesToScan("com.example.jwt.byDurgesh.Conteoller")

				// .headersToMatch("JWT", "Authorization") // Specify the package to scan
				.build();
	}
}
