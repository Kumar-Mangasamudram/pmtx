package com.bottomline.pmtx.payload.request;


public class SignUpRequest {
	private String name;
	
	private String email;
	
	private String password;
	
	private String role;
	
	
	
	public void setName(String username) {
        this.name = username;
    }
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
}
