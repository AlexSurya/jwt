/**
 * 
 */
package com.security.jwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author alexsurya
 *
 */

@Document(collection = "tbl_users")
public class User {

	@Id
	private String id;

	private String username;

	private String password;

	private String permissions;

	private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String username, String password, String permissions, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.permissions = permissions;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
