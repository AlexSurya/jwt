/**
 * 
 */
package com.security.jwt.configuration;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.jwt.model.User;
import com.security.jwt.service.UserService;

/**
 * @author alexsurya
 *
 */
@Service
public class InitialConfiguration implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bcrypt;

	@Override
	public void run(String... args) throws Exception {

		User admin = new User(null, "alex", bcrypt.encode("alex"), "API_1", "ADMIN");
		User user = new User(null, "surya", bcrypt.encode("surya"), "API_2", "USER");

		List<User> users = Arrays.asList(admin, user);
		Optional<User> ifUserExist = userService.getByUserName("alex");
		
		if (!ifUserExist.isPresent()) {
			userService.saveListOfUsers(users);
		}

	}

}
