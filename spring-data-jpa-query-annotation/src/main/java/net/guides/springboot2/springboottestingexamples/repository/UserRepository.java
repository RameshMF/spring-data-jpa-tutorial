package net.guides.springboot2.springboottestingexamples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);

	@Query("select u from User u where u.firstname like %?1")
	List<User> findByFirstnameEndsWith(String firstname);
}
