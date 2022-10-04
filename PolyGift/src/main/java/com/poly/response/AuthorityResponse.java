package com.poly.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityResponse {
	private Integer id;
	private AccountResponse account;
	private RoleResponse role;
}
