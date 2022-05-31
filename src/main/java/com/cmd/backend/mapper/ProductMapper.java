package com.cmd.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
	
	

	public static  List<ProductDto> fromListEntity(List<Product> listItem) {
			
		List<ProductDto> listProductDto = listItem.stream().map(product -> fromEntity(product)).collect(Collectors.toList());
	
		return listProductDto;
	}
	
	
	
}
