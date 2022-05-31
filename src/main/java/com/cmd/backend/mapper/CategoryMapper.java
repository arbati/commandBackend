package com.cmd.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.CategoryDto;
import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.entity.Category;
import com.cmd.backend.entity.Product;


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
	
	
	public static  List<CategoryDto> fromListEntity(List<Category> listItem) {
		
		List<CategoryDto> listItemDto = listItem.stream().map(item -> fromEntity(item)).collect(Collectors.toList());
	
		return listItemDto;
	}
	
	
}
