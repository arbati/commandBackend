package com.cmd.backend.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
