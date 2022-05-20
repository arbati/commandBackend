package com.cmd.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.backend.entity.Category;
import com.cmd.backend.exception.CategoryNotFoundExceptin;
import com.cmd.backend.repo.CategoryRepository;

import dto.CategoryDto;

import mapper.CategoryMapper;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository repository;
	
	@Override
	public CategoryDto get(Long id) throws CategoryNotFoundExceptin {
		
		Category item  = repository.findById(id).orElseThrow(()-> new CategoryNotFoundExceptin("Category not found"));
			
		return CategoryMapper.fromEntity(item);
	}

	@Override
	public CategoryDto save(CategoryDto itemDto) {
		
		Category item= CategoryMapper.fromDto(itemDto);	
		
		Category savedItem = repository.save(item);
		
		return CategoryMapper.fromEntity(savedItem);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public CategoryDto update(CategoryDto itemDto) {
		
        Category item= CategoryMapper.fromDto(itemDto);	
		
		Category savedItem = repository.save(item);
		
		return CategoryMapper.fromEntity(savedItem);
	}

	@Override
	public List<CategoryDto> getAll() {
		
		    List<Category> list = (List<Category>) repository.findAll();
			
			List<CategoryDto> listDto = list.stream().map(item -> CategoryMapper.fromEntity(item)).collect(Collectors.toList());
		
			return listDto;
	}

}
