package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.exception.ProductNotFoundExceptin;

public interface IProductService {

	public ProductDto get(Long id) throws ProductNotFoundExceptin;
	public ProductDto save(ProductDto prd);
	public void delete(Long id);
	public ProductDto update(ProductDto prd);
	public List<ProductDto> getAll();
	
	
}
