package com.cmd.backend.mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.entity.Product;

public class ProductMapper {

	
	
	public static ProductDto fromEntity(Product prd) {
		
		ProductDto prdDto = new ProductDto();
		
		BeanUtils.copyProperties(prd, prdDto);
		
		prdDto.setBrandDto(BrandMapper.fromEntity(prd.getBrand()));
		prdDto.setCategoryDto(CategoryMapper.fromEntity(prd.getCategory()));
		

	return prdDto;
	}
	
	public static Product fromDto(ProductDto prdDto) {
		
		Product prd= new Product();
		
		BeanUtils.copyProperties(prdDto, prd);
		
		prd.setBrand(BrandMapper.fromDto(prdDto.getBrandDto()));
		prd.setCategory(CategoryMapper.fromDto(prdDto.getCategoryDto()));
		
	return prd;
	}
	
	
	
}
