package br.com.application.appdemomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.application.appdemomongo.domain.Post;
import br.com.application.appdemomongo.repository.PostRepository;
import br.com.application.appdemomongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Object not found");
		}
		return obj.get();
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}
	

}
