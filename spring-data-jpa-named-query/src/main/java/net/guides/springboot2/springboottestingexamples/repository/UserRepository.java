package net.guides.springboot2.springboottestingexamples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboottestingexamples.model.User;

/**
 * UserRepository demonstrates the method name query generation.
 * 
 * @author Ramesh Fadatare
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailAddress(String emailAddress);

	List<User> findByLastname(String lastname);
}
