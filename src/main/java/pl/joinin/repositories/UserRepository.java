package pl.joinin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.joinin.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastName(String lastName);
}
