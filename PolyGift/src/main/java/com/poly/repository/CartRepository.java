package com.poly.repository;

import com.poly.entity.Account;
import com.poly.entity.Cart;
import com.poly.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "select c from Cart c where c.account.username =  :username")
    List<Cart> findByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE  FROM Cart c WHERE c.account.username= :username")
    void deleteByUsername(@Param("username") String username);

    @Query(value = "SELECT c FROM Cart c " +
            "WHERE c.product = :product " +
            "AND c.account = :account")
    Cart findByProductId(@Param("product") Product product, @Param("account") Account account);
}
