package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
