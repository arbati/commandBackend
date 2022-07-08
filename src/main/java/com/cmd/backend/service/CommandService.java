package com.cmd.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.backend.dto.CommandDto;
import com.cmd.backend.dto.DetailDto;
import com.cmd.backend.dto.ProductDto;
import com.cmd.backend.entity.Command;
import com.cmd.backend.entity.Detail;
import com.cmd.backend.entity.Product;
import com.cmd.backend.exception.CommandNotFoundExceptin;
import com.cmd.backend.mapper.CommandMapper;
import com.cmd.backend.mapper.DetailMapper;
import com.cmd.backend.mapper.ProductMapper;
import com.cmd.backend.repo.CommandRepository;
import com.cmd.backend.repo.DetailRepository;

@Service
public class CommandService implements ICommandService {

	@Autowired
	CommandRepository repository;
	
	@Autowired
	DetailRepository detailRepository;
	
	@Override
	public CommandDto get(Long id) throws CommandNotFoundExceptin {
		Command item  = repository.findById(id).orElseThrow(()-> new CommandNotFoundExceptin("Command not found"));
		
		return CommandMapper.fromEntity(item);
	}

	@Override
	public CommandDto save(CommandDto itemDto) {
		Command item= CommandMapper.fromDto(itemDto);	
		
		Command savedItem = repository.save(item);
		
		return CommandMapper.fromEntity(savedItem);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public CommandDto update(CommandDto itemDto) {
		Command item= CommandMapper.fromDto(itemDto);	
		
		Command savedItem = repository.save(item);
			
			return CommandMapper.fromEntity(savedItem);
	}

	@Override
	public List<CommandDto> getAll() {
		
		    List<Command> list = (List<Command>) repository.findAll();
			
			List<CommandDto> listDto = list.stream().map(item -> CommandMapper.fromEntity(item)).collect(Collectors.toList());
		
			return listDto;
	}

	
	
	@Override
	public List<ProductDto> getProducts(Long idCommand) throws CommandNotFoundExceptin {
		
		    Command item  = repository.findById(idCommand).orElseThrow(()-> new CommandNotFoundExceptin("Command not found"));
		
		    List<Product> listPrd = detailRepository.getProducts(item);
	        
	    	List<ProductDto> listDto = listPrd.stream().map(product -> ProductMapper.fromEntity(product)).collect(Collectors.toList());
			
			return listDto;
		
	}
	
	
    @Override
	public List<DetailDto> getDetails(Long idCommand) throws CommandNotFoundExceptin {
		
		    Command cmd  = repository.findById(idCommand).orElseThrow(()-> new CommandNotFoundExceptin("Command not found"));
		
		    List<Detail> listPrd = detailRepository.getDetails(cmd);
	        
	    	List<DetailDto> listDto = listPrd.stream().map(item -> DetailMapper.fromEntity(item)).collect(Collectors.toList());
		    
		    
			return listDto;
		
	}
	
    
    public List<Object> getCommandByYear(){
    	
    	return repository.getCommandByYear();
    }
    
    
    public List<Object> getTurnoverByYear(){
    	
    	return repository.getTurnoverByYear();
    }
    
    
    public List<Object> getTurnoverByMonth(){
    	
    	return repository.getTurnoverByMonth();
    }
    

}
