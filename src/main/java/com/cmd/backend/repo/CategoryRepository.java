package com.cmd.backend.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	@Query("select p from Category p where p.designation like :kw")
	List<Category> searchByKeyword(@Param("kw") String search);
	
	
}
