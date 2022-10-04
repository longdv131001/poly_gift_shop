package com.poly.repository;

import com.poly.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN (1,2)")
	List<Account> getAdministrators();

	@Query("SELECT a FROM Account a WHERE a.username = :username")
	Account findAccountByUsername(@Param("username") String username);

}
