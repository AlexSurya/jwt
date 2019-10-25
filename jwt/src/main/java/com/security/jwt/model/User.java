/**
 * 
 */
package com.security.jwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author alexsurya
 *
 */

@Document(collection = "tbl_users")
//@JsonFilter(value = "userFilter")
public class User {

	@Id
	@JsonView(JsonViews.Internal.class)
	private String id;

	@JsonView(JsonViews.External.class)
	private String username;

	@JsonView(JsonViews.Internal.class)
	private String password;

	@JsonView(JsonViews.Internal.class)
	private String permissions;

	@JsonView(JsonViews.External.class)
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
