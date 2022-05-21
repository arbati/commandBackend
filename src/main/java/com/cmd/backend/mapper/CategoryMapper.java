package com.cmd.backend.mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.CategoryDto;
import com.cmd.backend.entity.Category;


public class CategoryMapper {

	
	
	public static CategoryDto fromEntity(Category item) {
		
		CategoryDto itemDto= new CategoryDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
	return itemDto;
	}
	
	public static Category fromDto(CategoryDto itemDto) {
		
		Category item= new Category();
		
		BeanUtils.copyProperties(itemDto, item);
		
	return item;
	}
	
	
	
}
