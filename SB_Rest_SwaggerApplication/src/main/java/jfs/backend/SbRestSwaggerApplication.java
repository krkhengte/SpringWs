package jfs.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jfs.backend.rest.AirIndiaRestController;
/*import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

@SpringBootApplication

public class SbRestSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbRestSwaggerApplication.class, args);

	}

}
