package com.cmd.backend.dto;



public class DetailDto {

	private Long id;
	private Integer quantity;
    private ProductDto productDto;
	private CommandDto commandDto;
	
	
	
	public DetailDto() {
		
	}
	
	public DetailDto(Integer quantity, ProductDto productDto, CommandDto commandDto) {
		super();
		this.quantity = quantity;
		this.productDto = productDto;
		this.commandDto = commandDto;
	}
	
	public DetailDto(Long id, Integer quantity, ProductDto productDto, CommandDto commandDto) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.productDto = productDto;
		this.commandDto = commandDto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
