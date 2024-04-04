package jfs.backend;

import java.sql.PseudoColumnUsage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jfs.backend.repository.PersonRepository;
import jfs.backend.service.PersonService;

@SpringBootApplication
public class JpaOneToOneMappingApplication {
	


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaOneToOneMappingApplication.class, args);
		
		PersonRepository bean = context.getBean(PersonRepository.class);

		PersonService ps = context.getBean(PersonService.class);
			
			ps.addPersonInfo();
	}

}
