package br.com.application.appdemomongo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.appdemomongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User obj = new User("1", "Bill", "email@email.com");
		User obj1 = new User("2", "John", "email1@email.com");

		List<User> users = new ArrayList<>();
		users.add(obj);
		users.add(obj1);

		return ResponseEntity.ok().body(users);
	}

}
