package jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicesApplicationConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplicationConfigServerApplication.class, args);
	}

}
