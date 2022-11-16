package com.bottomline.pmtx.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "users",
	uniqueConstraints = {
			@UniqueConstraint(columnNames = "name"),
            @UniqueConstraint(columnNames = "email")
})

public class User {
    public User() {
		super();
	}


	public User(String name2, String email2, String password2, String role2) {
		this.name = name2;
		this.email = email2;
		this.password = password2;
		this.role = role2;
	}
    

	public String getName() {
    	return name;
    }
	
	public String getEmail() {
		return email;
	}
	
	public  String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;

    private String email;

    private String password;

    private String role;

	public long getId() {
		return id;
	}    

}
