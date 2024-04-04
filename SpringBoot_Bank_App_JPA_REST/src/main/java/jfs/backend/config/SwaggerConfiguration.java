
package jfs.backend.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {

	/*
	 * // @Bean // public Docket apiDoc() { // // return new
	 * Docket(DocumentationType.SWAGGER_2).select() //
	 * .apis(RequestHandlerSelectors.basePackage("jfs.backend.rest")).paths(
	 * PathSelectors.any()).build(); // // }
	 */@Bean
public GroupedOpenApi controllerApi() {
	return GroupedOpenApi.builder()
			.group("controller-api")
			.packagesToScan("jfs.backend.rest") // Specify the package to scan
			.build();
}
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Bank API")
						.description("Bank App sample application")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));
	}


}