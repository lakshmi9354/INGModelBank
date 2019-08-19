package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

public	Customer findByMobileNoAndPassword(String mobileNo, String password);
@Query(value = "select c.* from customer c where customer_id =:customerId",nativeQuery = true)
public Customer findByCustomerId(@Param("customerId") Integer customerId);
public Optional<Customer> findByCustomerId(int customerId);
}
