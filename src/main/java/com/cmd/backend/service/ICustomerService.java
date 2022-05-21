package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.dto.CustomerDto;
import com.cmd.backend.exception.CustomerNotFoundExceptin;

public interface ICustomerService {
	
	public CustomerDto get(Long id) throws CustomerNotFoundExceptin;
	public CustomerDto save(CustomerDto item);
	public void delete(Long id);
	public CustomerDto update(CustomerDto item);
	public List<CustomerDto> getAll();
	
	
}
