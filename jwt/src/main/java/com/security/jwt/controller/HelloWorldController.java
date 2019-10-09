/**
 * 
 */
package com.security.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexsurya
 *
 */
@RestController
@RequestMapping(path="jwt/**")
public class HelloWorldController {

	@GetMapping(path="hello")
	public String hello() {
		return "helloWorld";
	}
	
	@GetMapping(path="index")
	public String index() {
		return "authenticated";
	}
	
	@GetMapping(path="admin")
	public String adminAccess() {
		return "welcome Admin";
	}
	
	@GetMapping(path="api/test1")
	public String restAccessForAdmin() {
		return "test1";
	}
}
