package com.cmd.backend.dto;



public class DetailDto {

	private Long id;
	private Integer quatity;
    private ProductDto productDto;
	private CommandDto commandDto;
	
	
	
	public DetailDto() {
		
	}
	
	public DetailDto(Integer quatity, ProductDto productDto, CommandDto commandDto) {
		super();
		this.quatity = quatity;
		this.productDto = productDto;
		this.commandDto = commandDto;
	}
	
	public DetailDto(Long id, Integer quatity, ProductDto productDto, CommandDto commandDto) {
		super();
		this.id = id;
		this.quatity = quatity;
		this.productDto = productDto;
		this.commandDto = commandDto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuatity() {
		return quatity;
	}
	public void setQuatity(Integer quatity) {
		this.quatity = quatity;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	public CommandDto getCommandDto() {
		return commandDto;
	}
	public void setCommandDto(CommandDto commandDto) {
		this.commandDto = commandDto;
	}
	
	
	
	
	
}
