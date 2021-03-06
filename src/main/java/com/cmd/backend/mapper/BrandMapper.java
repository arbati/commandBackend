package com.cmd.backend.mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.BrandDto;
import com.cmd.backend.entity.Brand;


public class BrandMapper {

	
	
	public static BrandDto fromEntity(Brand item) {
		
		BrandDto itemDto= new BrandDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
	return itemDto;
	}
	
	public static Brand fromDto(BrandDto itemDto) {
		
		Brand item= new Brand();
		
		BeanUtils.copyProperties(itemDto, item);
		
	return item;
	}
	
	
	
}
