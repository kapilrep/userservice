package org.connect.userservice;

import org.connect.userservice.model.User;
import org.connect.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

	@Configuration
	class LoadInitialDatabase {
	  
	  Logger log = LoggerFactory.getLogger(LoadInitialDatabase.class);
		 
	  @Bean
	  CommandLineRunner initDatabase(UserRepository repository) {
		  //blank it first 
		  repository.deleteAll();
		  
	    return args -> {
	      log.info("Preloading " + repository.save(new User("1", "Kapil", "kmadan@hotmail.com",40)));
	      log.info("Preloading " + repository.save(new User("2", "Frodo Baggins", "frodo@gmail.com",90)));
	    };
	  }
	}

