package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountId(Integer accountNumber);

	@Query(value = "select a.* from account a where a.customer_id=:customerId", nativeQuery = true)
	public Account findByCustomer(@Param("customerId") Integer customerId);

public Optional<Account> findByAccountId(int accountId);

}
