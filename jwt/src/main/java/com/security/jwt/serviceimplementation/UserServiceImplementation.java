/**
 * 
 */
package com.security.jwt.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.jwt.model.User;
import com.security.jwt.repository.UserRepository;
import com.security.jwt.service.UserService;

/**
 * @author alexsurya
 *
 */
@Service
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public void saveListOfUsers(List<User> users) {
		userRepository.saveAll(users);
	}


	@Override
	public Optional<User> getByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
