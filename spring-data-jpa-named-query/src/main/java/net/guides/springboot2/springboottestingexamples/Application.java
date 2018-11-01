package net.guides.springboot2.springboottestingexamples;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.guides.springboot2.springboottestingexamples.model.User;
import net.guides.springboot2.springboottestingexamples.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(); 
		user.setActive(1);
		user.setAge(28);
		user.setEmailAddress("ramesh24@gmail.com");
		user.setFirstname("Ramesh");
		user.setLastname("Fadatare");
		user.setStartDate(new Date());
		user = userRepository.save(user);
		
		System.out.println("-------------------------------------:: " + user.getId());
		
		System.out.println(" ---------------@NamedNativeQuery ---------------------");
		System.out.println("--------------findByEmailAddress -----------------");
		
		User user2 = userRepository.findByEmailAddress("ramesh24@gmail.com");
		System.out.println(user2.toString());
		
		System.out.println(" ---------------@NamedNativeQueries ---------------------");
		System.out.println("--------------findByLastname -----------------");
		
		List<User> user3 = userRepository.findByLastname("Fadatare");
		System.out.println(user3.get(0).toString());
	}
}
