package com.cmd.backend.mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.DetailDto;
import com.cmd.backend.entity.Detail;

public class DetailMapper {

	
	
	public static DetailDto fromEntity(Detail item) {
		
		DetailDto itemDto = new DetailDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
		itemDto.setCommandDto(CommandMapper.fromEntity(item.getCommand()));
		itemDto.setProductDto(ProductMapper.fromEntity(item.getProduct()));
		

	return itemDto;
	}
	
	public static Detail fromDto(DetailDto itemDto) {
		
		Detail item= new Detail();
		
		BeanUtils.copyProperties(itemDto, item);
		
		item.setCommand(CommandMapper.fromDto(itemDto.getCommandDto()));
		item.setProduct(ProductMapper.fromDto(itemDto.getProductDto()));
		
	return item;
	}
	
	
	
}
