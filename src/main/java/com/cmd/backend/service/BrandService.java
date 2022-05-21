package com.cmd.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.backend.dto.BrandDto;
import com.cmd.backend.entity.Brand;
import com.cmd.backend.exception.BrandNotFoundExceptin;
import com.cmd.backend.mapper.BrandMapper;
import com.cmd.backend.repo.BrandRepository;

@Service
public class BrandService implements IBrandService {

	@Autowired
	BrandRepository repository;
	
	
	@Override
	public BrandDto get(Long id) throws BrandNotFoundExceptin {

	      Brand item  = repository.findById(id).orElseThrow(()-> new BrandNotFoundExceptin("Brand not found"));
		
		return BrandMapper.fromEntity(item);
	}

	
	
	@Override
	public BrandDto save(BrandDto itemDto) {
		
		Brand item= BrandMapper.fromDto(itemDto);	
		
		Brand savedItem = repository.save(item);
		
		return BrandMapper.fromEntity(savedItem);
	}
	

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public BrandDto update(BrandDto itemDto) {
		
        Brand item= BrandMapper.fromDto(itemDto);	
		
		Brand savedItem = repository.save(item);
		
		return BrandMapper.fromEntity(savedItem);
	}
	

	@Override
	public List<BrandDto> getAll() {
	
	    List<Brand> list = (List<Brand>) repository.findAll();
		
		List<BrandDto> listDto = list.stream().map(item -> BrandMapper.fromEntity(item)).collect(Collectors.toList());
	
		return listDto;
		
	}

}
