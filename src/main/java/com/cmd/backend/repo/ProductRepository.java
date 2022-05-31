package com.cmd.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	
	@Query("select p from Product p where p.designation like :kw")
	List<Product> searchProduct(@Param("kw") String search);
	
	
}
