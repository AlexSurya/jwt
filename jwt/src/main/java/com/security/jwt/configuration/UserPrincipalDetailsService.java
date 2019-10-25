/**
 * 
 */
package com.security.jwt.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.jwt.model.User;
import com.security.jwt.service.UserService;

/**
 * @author alexsurya
 *
 */
@Service
public class UserPrincipalDetailsService implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userService.getByUserName(username);
		if (user.isPresent()) {
			UserPrincipal userPrincipal = new UserPrincipal(user.get());
			return userPrincipal;
		} 
		return new UserPrincipal(new User());
		
	}

}
