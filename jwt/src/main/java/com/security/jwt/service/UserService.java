/**
 * 
 */
package com.security.jwt.service;

import java.util.List;
import java.util.Optional;

import com.security.jwt.model.User;

/**
 * @author alexsurya
 *
 */
public interface UserService {

	public List<User> getAllUsers();
	
	public void saveListOfUsers(List<User> users);
	
	public Optional<User> getByUserName(String username);
}
