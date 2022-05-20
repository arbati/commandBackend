package dto;

import java.io.Serializable;



public class CategoryDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String designation;
	
	
	
	public CategoryDto() {}

	public CategoryDto( String designation) {
		super();
		this.designation = designation;
	}
	
	public CategoryDto(long id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}


	
}
