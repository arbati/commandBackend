package com.cmd.backend.web;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.backend.dto.CustomerDto;
import com.cmd.backend.exception.CustomerNotFoundExceptin;
import com.cmd.backend.service.CustomerService;

@RestController
@RequestMapping("customer-rest")
@CrossOrigin("*")
public class CustomerController {

		@Autowired
		CustomerService service;
	
	
	   
		@GetMapping("/{id}")
	    public CustomerDto getById(@PathVariable long id) {
		  
			CustomerDto itemDto=null;
			
			try {
				itemDto=service.get(id);
			} catch (CustomerNotFoundExceptin e) {
				e.printStackTrace();
			}
			
	        return itemDto;
	    }
	
		
		@GetMapping("/all")
	    public ArrayList<CustomerDto> getAll() {
		  
	        return (ArrayList<CustomerDto>) service.getAll();
	    }
		
		@DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
			
			service.delete(id);
			 
	    }
		
		
		@PostMapping("/save")
		public CustomerDto save(@RequestBody CustomerDto itemDto) {
			
			return  service.save(itemDto);
			
		}
		
		
		@PutMapping("/{id}")
	    public CustomerDto update(@PathVariable long id, @RequestBody CustomerDto itemDto) {
			
			itemDto.setId(id);
			
			return  service.update(itemDto);
			 
	    }
		
		
		
}
