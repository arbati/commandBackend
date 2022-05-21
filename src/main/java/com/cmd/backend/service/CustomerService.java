package com.cmd.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.backend.dto.CustomerDto;
import com.cmd.backend.entity.Customer;
import com.cmd.backend.exception.CustomerNotFoundExceptin;
import com.cmd.backend.mapper.CustomerMapper;
import com.cmd.backend.repo.CustomerRepository;
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository repository;
	
	@Override
	public CustomerDto get(Long id) throws CustomerNotFoundExceptin {
		Customer item  = repository.findById(id).orElseThrow(()-> new CustomerNotFoundExceptin("Category not found"));
		
		return CustomerMapper.fromEntity(item);
	}

	@Override
	public CustomerDto save(CustomerDto itemDto) {
		
		Customer item= CustomerMapper.fromDto(itemDto);	
		
		Customer savedItem = repository.save(item);
		
		return CustomerMapper.fromEntity(savedItem);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public CustomerDto update(CustomerDto itemDto) {
		Customer item= CustomerMapper.fromDto(itemDto);	
			
		Customer savedItem = repository.save(item);
			
			return CustomerMapper.fromEntity(savedItem);
	}

	@Override
	public List<CustomerDto> getAll() {
		
		 List<Customer> list = (List<Customer>) repository.findAll();
			
			List<CustomerDto> listDto = list.stream().map(item -> CustomerMapper.fromEntity(item)).collect(Collectors.toList());
		
			return listDto;
	}

}
