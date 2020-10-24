package br.com.application.appdemomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.application.appdemomongo.domain.User;
import br.com.application.appdemomongo.dto.UserDTO;
import br.com.application.appdemomongo.repository.UserRepository;
import br.com.application.appdemomongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Object not found");
		}
		return obj.get();
	}

	public void delete(String id) {
		User user = findById(id);
		repository.delete(user);
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User update(User obj) {
		User user = findById(obj.getId());
		updateData(user,obj);
		return repository.save(user);
	}

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}

}
