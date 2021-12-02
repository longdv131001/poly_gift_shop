package com.poly.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String jwttoken;
	private String role;
	
	public JwtResponse(String jwttoken) {
		setJwttoken(jwttoken);
	}

	
	
	public JwtResponse(String jwttoken, String role) {
		super();
		this.jwttoken = jwttoken;
		this.setRole(role);
	}



	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

}
