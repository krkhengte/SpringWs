package jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jfs.backend.service.CategoryService;
import jfs.backend.service.StudentService;

@SpringBootApplication
public class JpaOneToManyMapping1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaOneToManyMapping1Application.class, args);
		StudentService ss = context.getBean(StudentService.class);
		ss.addStudentInfo();
		
		CategoryService cs = context.getBean(CategoryService.class);
		cs.addcategoryService();
	}

}
