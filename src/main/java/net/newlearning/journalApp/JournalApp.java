package net.newlearning.journalApp;

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
@EnableTransactionManagement
public class JournalApp {

	public static void main(String[] args) {


		 ConfigurableApplicationContext context =   SpringApplication.run(JournalApp.class, args);
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment.getActiveProfiles());

	}
	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return  new MongoTransactionManager(dbFactory);
	}

}
//PlatformTranscationManager  Interface
//MonogoTransactionManager
