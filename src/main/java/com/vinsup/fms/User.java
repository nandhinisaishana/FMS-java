package com.vinsup.fms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	
	
	public User() {
		
	}
	
	public User(String username, String password, Role role) {
		this.username=username;
		this.password=password;
		this.role=role;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return username;
	}
	public void setName(String name)
	{
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role=role;
	}
}
