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

import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.exception.ProductNotFoundExceptin;
import com.cmd.backend.service.ProductService;

@RestController
@RequestMapping("api/v1/product")
// @ CrossOrigin("*")
public class ProductController {

		@Autowired
		ProductService productService;
	
	   
		@GetMapping("/{id}")
	    public ProductDto getById(@PathVariable long id) {
		  
			ProductDto productDto=null;
			
	        try {
	        	productDto = productService.get(id);
			} catch (ProductNotFoundExceptin e) {
				
				e.printStackTrace();
			}
	        
	        return productDto;
	    }
	
		@PostMapping("/save")
		public ProductDto save(@RequestBody ProductDto prdDto) {
			
			return  productService.save(prdDto);
			
		}
		
		
		@GetMapping("/all")
	    public ArrayList<ProductDto> getAll() {
		  
	        return (ArrayList<ProductDto>) productService.getAll();
	    }
		
		
		@PutMapping("update/{id}")
		public ProductDto update(@PathVariable Long id,@RequestBody ProductDto prdDto) {
			
			prdDto.setId(id);
			
			return  productService.update(prdDto);
		}
		
		
		
		@DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
			
			productService.delete(id);
			 
	    }
		
		
		
		
		
		
		
}
