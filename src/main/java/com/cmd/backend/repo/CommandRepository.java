package com.cmd.backend.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmd.backend.entity.Command;
import com.cmd.backend.entity.Detail;
@Repository
public interface CommandRepository extends CrudRepository<Command, Long> {
	
	
	
	 @Query("select YEAR(c.orderDate) as yearOrder, count(c.id) as commandCount, c.valid from Command c GROUP BY YEAR(c.orderDate), c.valid ")
	 List<Object> getCommandByYear();
	 
	 @Query("select YEAR(d.command.orderDate) as yearOrder, sum(d.product.price*d.quantity) as commandCount, d.command.valid from Detail d GROUP BY YEAR(d.command.orderDate), d.command.valid ")
	 List<Object> getTurnoverByYear();
	 
	 @Query("select  MONTH(d.command.orderDate) as monthOrder, YEAR(d.command.orderDate) as yearOrder, sum(d.product.price*d.quantity) as commandCount, d.command.valid from Detail d GROUP BY YEAR(d.command.orderDate), MONTH(d.command.orderDate), d.command.valid ")
	 List<Object> getTurnoverByMonth();

}
