package com.polygift.dto;

import java.util.List;

import com.polygift.entity.Authority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private String id;
	private String name;
	List<Authority> authorities;
}
