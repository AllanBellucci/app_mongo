package br.com.application.appdemomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.application.appdemomongo.domain.Post;
import br.com.application.appdemomongo.domain.User;
import br.com.application.appdemomongo.dto.AuthorDTO;
import br.com.application.appdemomongo.repository.PostRepository;
import br.com.application.appdemomongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		
		User user1 = new User(null, "Ross", "ross@mail.com");
		User user2 = new User(null, "Sindy", "sindy@mail.com");
		User user3 = new User(null, "Taylor", "taylor@mail.com");
		
		Post post  = new Post(null, sdf.parse("22/10/2018"), "Lets go trip", "I'm going to travel to São Paulo, bye",new AuthorDTO(user1));
		
		repository.saveAll(Arrays.asList(user1,user2,user3));
		postRepository.save(post);
		
		user1.getPosts().add(post);
		
		repository.save(user1);
	}

}
