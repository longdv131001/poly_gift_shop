package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

	List<Role> findAll();

}
