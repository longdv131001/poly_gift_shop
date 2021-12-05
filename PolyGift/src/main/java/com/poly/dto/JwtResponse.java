package com.poly.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String jwttoken;
	private UserInfo user;
	

}
