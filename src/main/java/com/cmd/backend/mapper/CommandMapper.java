package com.cmd.backend.mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.dto.CommandDto;
import com.cmd.backend.entity.Command;


public class CommandMapper {

	
	public static CommandDto fromEntity(Command item) {
		
		CommandDto itemDto= new CommandDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
		itemDto.setCustomerDto(CustomerMapper.fromEntity(item.getCustomer()));
		
	return itemDto;
	}
	
	public static Command fromDto(CommandDto itemDto) {
		
		Command item= new Command();
		
		BeanUtils.copyProperties(itemDto, item);
		
		item.setCustomer(CustomerMapper.fromDto(itemDto.getCustomerDto()));
		
	return item;
	}
	
	
	
}
