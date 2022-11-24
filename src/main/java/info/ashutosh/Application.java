package info.ashutosh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import info.ashutosh.entity.Method;
import info.ashutosh.entity.Methods;
import info.ashutosh.reposetory.MethodsReposetory;

@SpringBootApplication
public class Application {

	Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner loadData(MethodsReposetory repository) {
		logger.warn("Data Insertion starts..");
		// save a couple of Methods
		repository.save(new Methods(Method.GET, Method.GET));
		repository.save(new Methods(Method.POST, Method.POST));
		repository.save(new Methods(Method.UPDATE, Method.UPDATE));
		repository.save(new Methods(Method.DELETE, Method.DELETE));
		repository.save(new Methods(Method.PUT, Method.PUT));
		logger.warn("Data Insertion ended.");
		return null;

	}
}
