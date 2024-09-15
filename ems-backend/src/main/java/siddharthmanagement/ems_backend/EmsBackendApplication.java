package siddharthmanagement.ems_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("siddharthmanagement.entity")
@ComponentScan(basePackages = {"siddharthmanagement","siddharthmanagement.exception"})
@EnableJpaRepositories(basePackages = "siddharthmanagement.repository")
//@ComponentScan(basePackages = {
//		"siddharthmanagement.controller",
//		"siddharthmanagement.service",
//		"siddharthmanagement.service.impl",
////		"siddharthmanagement.repository"
//})
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

}
