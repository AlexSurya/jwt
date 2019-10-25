/**
 * 
 */
package com.security.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.jwt.model.JsonViews;
import com.security.jwt.model.User;
import com.security.jwt.service.UserService;

/**
 * @author alexsurya
 *
 */
@RestController
@RequestMapping("view/")
public class JsonViewController {

	@Autowired
	UserService userService;

	@JsonView(JsonViews.External.class)
	@GetMapping(path="users/list/external")
	public List<User> getListOfUsersForInternal() {
		return userService.getAllUsers();
	}
	
	@JsonView(JsonViews.Internal.class)
	@GetMapping(path="users/list/internal") 
	public List<User> getListOfUsersForExternal() {
		return userService.getAllUsers();
	}
}
