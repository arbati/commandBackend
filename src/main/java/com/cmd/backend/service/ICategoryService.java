package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.dto.CategoryDto;
import com.cmd.backend.exception.CategoryNotFoundExceptin;

public interface ICategoryService {
	
	public CategoryDto get(Long id) throws CategoryNotFoundExceptin;
	public CategoryDto save(CategoryDto item);
	public void delete(Long id);
	public CategoryDto update(CategoryDto item);
	public List<CategoryDto> getAll();
	public List<CategoryDto> searchByKeyword(String kw);

	
	
}
