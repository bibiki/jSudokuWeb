package org.games.sudoku.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {

	private String id;
	private String email;
	private String username;
	private String password;
	
	@Id
	@Column( name = "id", length = 16, nullable = false)
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	@Column(name = "email", length = 50, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column( name = "username", length = 20, nullable = false)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@Column( name = "password", length = 20, nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
