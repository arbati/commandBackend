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

import com.cmd.backend.exception.CommandNotFoundExceptin;
import com.cmd.backend.service.CommandService;

import dto.CommandDto;
import dto.ProductDto;

@RestController
@RequestMapping("order-rest")
@CrossOrigin("*")
public class OrderController {

		@Autowired
		CommandService service;
	
	
	   
		@GetMapping("/{id}")
	    public CommandDto getById(@PathVariable long id) {
		  
			
			CommandDto commandDto= null;
			
	        try {
				commandDto = service.get(id);
			} catch (CommandNotFoundExceptin e) {
				e.printStackTrace();
			}
	        
	        return commandDto;
	        
	    }
	
		
		@GetMapping("/all")
	    public ArrayList<CommandDto> getAll() {
		  
	        return (ArrayList<CommandDto>) service.getAll();
	    }
		
		
		@PostMapping("/save")
		public CommandDto save(@RequestBody CommandDto itemDto) {
			
			return  service.save(itemDto);
			
		}
		
		@PutMapping("update/{id}")
		public CommandDto update(@PathVariable Long id,@RequestBody CommandDto itemDto) {
			
			itemDto.setId(id);
			
			return  service.update(itemDto);
		}
		
		
		@DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
			
			service.delete(id);
			 
	    }
		
		
		
		   
				@GetMapping("products/{id}")
		public ArrayList<ProductDto> getProducts(@PathVariable long id) {
				  
					
					ArrayList<ProductDto> listDto= null;
					
			        try {
			        	listDto = (ArrayList<ProductDto>) service.getProducts(id);
					} catch (CommandNotFoundExceptin e) {
						e.printStackTrace();
					}
			        
			        return listDto;
			        
		}
		
		
		
}
