package com.cmd.backend.dto;

import java.io.Serializable;



public class BrandDto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String designation;
	
	public BrandDto() {}
	
	public BrandDto( String designation) {
		super();
		this.designation = designation;
	}
	
	public BrandDto(Long id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
}
