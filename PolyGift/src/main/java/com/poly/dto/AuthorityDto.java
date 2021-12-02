package com.poly.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
    private Integer id;
	private AccountDto account;
	private RoleDto role;
}
