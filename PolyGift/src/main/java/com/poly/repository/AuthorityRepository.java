package com.poly.repository;

import com.poly.entity.Account;
import com.poly.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN :accounts")
	List<Authority> authoritiesOf(@Param("accounts") List<Account> accounts);

}
