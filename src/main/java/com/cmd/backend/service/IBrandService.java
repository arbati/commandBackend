package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.dto.BrandDto;
import com.cmd.backend.exception.BrandNotFoundExceptin;

public interface IBrandService {
	
	public BrandDto get(Long id) throws BrandNotFoundExceptin;
	public BrandDto save(BrandDto item);
	public void delete(Long id);
	public BrandDto update(BrandDto itemDto);
	public List<BrandDto> getAll();
	
	
}
