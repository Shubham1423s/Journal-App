package com.shubham.projects.journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement// so it can detect the method which is annotated with Transaction
// and we can put this annotation in the main class only
// now the question is who starts the Transaction who roll back if something happen
//so we need manager for this we use  PlatformTransactionManager
public class JournalAppApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(JournalAppApplication.class, args);
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment.getActiveProfiles()[0]);
//		SpringApplication.run();

	}
	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
		//all the things we done in the database by the instance of this
	}

	// so PlatformTransactionManager is an interface so  MongoTransactionManager implements it
}
