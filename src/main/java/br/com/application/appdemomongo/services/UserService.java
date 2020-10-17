package br.com.application.appdemomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.application.appdemomongo.domain.User;
import br.com.application.appdemomongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired		
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
}
