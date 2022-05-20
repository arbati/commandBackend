package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.exception.CategoryNotFoundExceptin;
import dto.CategoryDto;

public interface ICategoryService {
	
	public CategoryDto get(Long id) throws CategoryNotFoundExceptin;
	public CategoryDto save(CategoryDto item);
	public void delete(Long id);
	public CategoryDto update(CategoryDto item);
	public List<CategoryDto> getAll();
	
	
}
