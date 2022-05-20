package com.cmd.backend.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
