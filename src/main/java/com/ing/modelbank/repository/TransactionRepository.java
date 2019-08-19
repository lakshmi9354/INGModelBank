package com.ing.modelbank.repository;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.modelbank.entity.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction,String>{

	

	List<Transaction> findByaccountNumber(int accountNumber);

}
