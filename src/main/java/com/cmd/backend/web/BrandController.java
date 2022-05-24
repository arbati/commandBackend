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

import com.cmd.backend.dto.BrandDto;
import com.cmd.backend.exception.BrandNotFoundExceptin;
import com.cmd.backend.service.BrandService;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {

		@Autowired
		BrandService service;
	
	
		@GetMapping("/{id}")
	    public BrandDto getById(@PathVariable long id) {
			
			BrandDto brand=null;
			try {
				brand = service.get(id);
			} catch (BrandNotFoundExceptin e) {
				e.printStackTrace();
			}
			 
	        return brand;
	    }
	
		
		@GetMapping("/all")
	    public ArrayList<BrandDto> getAll() {
		  
	        return (ArrayList<BrandDto>) service.getAll();
	    }
		
		
		
		@PostMapping("/save")
		public BrandDto save(@RequestBody BrandDto itemDto) {
			
			return  service.save(itemDto);			
		}
		
		
		@PutMapping("/{id}")
	    public BrandDto update(@PathVariable long id, @RequestBody BrandDto itemDto) {
			
			itemDto.setId(id);
			
			return  service.update(itemDto);
			 
	    }
		
		
		@DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
			
			 service.delete(id);
			 
	    }
		
		
}
