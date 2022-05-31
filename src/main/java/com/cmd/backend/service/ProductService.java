package com.cmd.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.entity.Product;
import com.cmd.backend.exception.ProductNotFoundExceptin;
import com.cmd.backend.mapper.ProductMapper;
import com.cmd.backend.repo.ProductRepository;

@Service
public class ProductService implements IProductService{

	
	@Autowired
	ProductRepository productRepository;
	

	@Override
	public ProductDto get(Long id) throws ProductNotFoundExceptin {
		
		Product prod  = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundExceptin("Product not found"));
		
		return ProductMapper.fromEntity(prod);
	}


	public List<ProductDto> getByKeyword(String keyword) throws ProductNotFoundExceptin {
		
		List<Product> listProd  = productRepository.searchProduct("%"+keyword+"%");
		
		return ProductMapper.fromListEntity(listProd);
	}

	
	
	
	
	@Override
	public ProductDto save(ProductDto prd) {
		
	Product product= ProductMapper.fromDto(prd);	
	
	Product savedProduct = productRepository.save(product);
	
	return ProductMapper.fromEntity(savedProduct);
	}


	@Override
	public void delete(Long id) {
		
		productRepository.deleteById(id);	
		
	}


	@Override
	public ProductDto update(ProductDto prd) {
	
		Product product= ProductMapper.fromDto(prd);	
		
		Product savedProduct = productRepository.save(product);
		
		return ProductMapper.fromEntity(savedProduct);
	}


	@Override
	public List<ProductDto> getAll() {
		
		List<Product> listProduct = (List<Product>) productRepository.findAll();
		
		List<ProductDto> listProductDto = listProduct.stream().map(product -> ProductMapper.fromEntity(product)).collect(Collectors.toList());
	
		return listProductDto;
	}
	
	
	
	
	
	
	
	
}
