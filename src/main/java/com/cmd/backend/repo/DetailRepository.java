package com.cmd.backend.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Command;
import com.cmd.backend.entity.Detail;
import com.cmd.backend.entity.Product;
@Repository
public interface DetailRepository extends CrudRepository<Detail, Long> {

	
	 @Query("select d.product from Detail d where d.command= ?1")
	 List<Product> getProducts(Command command);
	
	
	 @Query("select d from Detail d where d.command= ?1")
	 List<Detail> getDetails(Command command);
	
	
}
