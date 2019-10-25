/**
 * 
 */
package com.security.jwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.model.LoginViewModel;
import com.security.jwt.model.User;
import com.security.jwt.service.UserService;

/**
 * @author alexsurya
 *
 */
@RestController
@RequestMapping(path = "jwt/")
public class HelloWorldController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "hello")
	public String hello() {
		return "helloWorld";
	}

	@GetMapping(path = "index")
	public String index() {
		return "authenticated";
	}

	@GetMapping(path = "admin")
	public String adminAccess() {
		return "welcome Admin";
	}

	@GetMapping(path = "api/test1")
	public String restAccessForAdmin() {
		return "test1";
	}

	@GetMapping(path = "api/user/list")
	public List<User> listOfUsers() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "login")
	public void login(@RequestBody LoginViewModel login) throws AuthenticationException {

	}
}
