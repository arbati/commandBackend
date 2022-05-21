package com.cmd.backend.service;

import java.util.List;

import com.cmd.backend.dto.CommandDto;
import com.cmd.backend.dto.DetailDto;
import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.exception.CommandNotFoundExceptin;

public interface ICommandService {
	
	public CommandDto get(Long id) throws CommandNotFoundExceptin;
	public CommandDto save(CommandDto item);
	public void delete(Long id);
	public CommandDto update(CommandDto item);
	public List<CommandDto> getAll();
	public List<ProductDto> getProducts(Long idCommand) throws CommandNotFoundExceptin;
	List<DetailDto> getDetails(Long idCommand) throws CommandNotFoundExceptin;
	
}
