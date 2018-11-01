package net.guides.springboot2.springboottestingexamples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboottestingexamples.model.Employee;
import net.guides.springboot2.springboottestingexamples.model.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByFirstName(String username);
	List<User> findByLastName(String lastname);
}
