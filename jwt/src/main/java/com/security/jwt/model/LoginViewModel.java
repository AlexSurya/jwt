/**
 * 
 */
package com.security.jwt.model;

/**
 * @author alexsurya
 * used for login only
 */
public class LoginViewModel {

	private String Username;

	private String password;

	public LoginViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginViewModel(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
