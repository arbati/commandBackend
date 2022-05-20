package mapper;

import org.springframework.beans.BeanUtils;

import com.cmd.backend.entity.Command;

import dto.CommandDto;


public class CommandMapper {

	
	
	public static CommandDto fromEntity(Command item) {
		
		CommandDto itemDto= new CommandDto();
		
		BeanUtils.copyProperties(item, itemDto);
		
	return itemDto;
	}
	
	public static Command fromDto(CommandDto itemDto) {
		
		Command item= new Command();
		
		BeanUtils.copyProperties(itemDto, item);
		
	return item;
	}
	
	
	
}
