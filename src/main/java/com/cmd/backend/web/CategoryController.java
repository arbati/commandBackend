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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.backend.dto.CategoryDto;
import com.cmd.backend.exception.CategoryNotFoundExceptin;
import com.cmd.backend.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

		@Autowired
		CategoryService service;
	
	
	   
		@GetMapping("/{id}")
	    public CategoryDto getById(@PathVariable long id) {
		  
			CategoryDto categoryDto = null;
	        try {
	        	categoryDto= service.get(id);
	        	
			} catch (CategoryNotFoundExceptin e) {
				e.printStackTrace();
			}
	        
	        return categoryDto;
	    }
	
		
		@GetMapping("/search")
	    public ArrayList<CategoryDto> searchByKeyword(@RequestParam("v") String keyword) {
		  
	        return (ArrayList<CategoryDto>) service.searchByKeyword("%"+keyword+"%");
	    }	
		
		
		@GetMapping("/all")
	    public ArrayList<CategoryDto> getAll() {
		  
	        return (ArrayList<CategoryDto>) service.getAll();
	    }	
		
		
		@DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
			
			service.delete(id);
			 
	    }
		
		
		
		
		
		@PostMapping("/save")
		public CategoryDto save(@RequestBody CategoryDto itemDto) {
			
			return  service.save(itemDto);
			
		}
		
		
		@PutMapping("/")
	    public CategoryDto update(@RequestBody CategoryDto itemDto) {
			
			//itemDto.setId(id);
			
			return  service.update(itemDto);
			 
	    }
		
		
		
}
