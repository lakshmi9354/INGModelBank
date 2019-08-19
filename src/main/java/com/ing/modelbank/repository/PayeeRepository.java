package com.ing.modelbank.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee,Integer> {
	
	@Modifying
	@Transactional
@Query("update Payee c set c.payeeName=:payeeName,c.payeeAccountType=:payeeAccountType where c.payeeId=:payeeId")
void update( int payeeId, String payeeName,String payeeAccountType);

Optional<Payee>  findBypayeeId(int payeeId);
@Modifying
@Transactional
@Query("update Payee c set c.payeeAccountNumber=:accountNumber where c.payeeId=:payeeId")
void updatePayee(int payeeId,int accountNumber);
@Query(value = "select p.* from payeelist p where p.account_id =:accountId",nativeQuery = true)
	List<Payee> findByCustomerId(@Param("accountId")Integer accountId);
}
