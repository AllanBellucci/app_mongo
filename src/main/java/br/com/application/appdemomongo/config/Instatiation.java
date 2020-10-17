package br.com.application.appdemomongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.application.appdemomongo.domain.User;
import br.com.application.appdemomongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		
		User user1 = new User(null, "Ross", "ross@mail.com");
		User user2 = new User(null, "Sindy", "sindy@mail.com");
		User user3 = new User(null, "Taylor", "taylor@mail.com");
		
		repository.saveAll(Arrays.asList(user1,user2,user3));
		
	}

}
