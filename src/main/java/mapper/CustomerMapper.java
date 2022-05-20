package mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.entity.Customer;

import dto.CustomerDto;


public class CustomerMapper {

	
	
	public static CustomerDto fromEntity(Customer item) {
		
		CustomerDto itemDto= new CustomerDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
	return itemDto;
	}
	
	public static Customer fromDto(CustomerDto itemDto) {
		
		Customer item= new Customer();
		
		BeanUtils.copyProperties(itemDto, item);
		
	return item;
	}
	
	
	
}
