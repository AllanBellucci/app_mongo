package br.com.application.appdemomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.application.appdemomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
