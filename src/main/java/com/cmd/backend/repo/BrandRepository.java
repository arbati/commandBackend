package com.cmd.backend.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Brand;
@Repository
public interface BrandRepository extends CrudRepository<Brand, Long>{

}
