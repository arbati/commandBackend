package com.cmd.backend.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Command;
@Repository
public interface CommandRepository extends CrudRepository<Command, Long> {

}
