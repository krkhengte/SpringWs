package jfs.backend;

import java.awt.print.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.context.ConfigurableApplicationContext;

import jfs.backend.entity.User;
import jfs.backend.repository.UserRepository;

@SpringBootApplication
public class LibraryManagementSystemAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LibraryManagementSystemAppApplication.class, args);
		/*
		 * User user = context.getBean(User.class); Book book =
		 * context.getBean(Book.class); Address address =
		 * context.getBean(Address.class);
		 */

		UserRepository userRepository = context.getBean(UserRepository.class);
	}

}
