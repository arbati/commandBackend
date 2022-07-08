package com.cmd.backend.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query("select c from Customer c where c.firstName like :kw Or c.lastName like :kw")
	List<Customer> searchByKeyWord(@Param("kw") String search);

}
