package dto;


import java.io.Serializable;
import java.util.Date;

public class ProductDto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long  id;
	private String photo;
	private String designation;
	private Double price;
	private Integer depositQuantity;
	private Date expirationDate;
	private String shortDescription;
	private String fullDescription;
	private BrandDto brandDto;
	private CategoryDto categoryDto;
	
	
	
	public ProductDto() {}
	
	public ProductDto(String photo, String designation, Double price, Integer depositQuantity,
			Date expirationDate, String shortDescription, String fullDescription, BrandDto brandDto, CategoryDto categoryDto ) {
		super();
		this.photo = photo;
		this.designation = designation;
		this.price = price;
		this.depositQuantity = depositQuantity;
		this.expirationDate = expirationDate;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.brandDto=brandDto;
		this.categoryDto=categoryDto;
	}
	
	public ProductDto(Long id, String photo, String designation, Double price, Integer depositQuantity,
			Date expirationDate, String shortDescription, String fullDescription, BrandDto brandDto, CategoryDto categoryDto) {
		super();
		this.id = id;
		this.photo = photo;
		this.designation = designation;
		this.price = price;
		this.depositQuantity = depositQuantity;
		this.expirationDate = expirationDate;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.brandDto = brandDto;
		this.categoryDto = categoryDto;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getDepositQuantity() {
		return depositQuantity;
	}
	public void setDepositQuantity(Integer depositQuantity) {
		this.depositQuantity = depositQuantity;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public BrandDto getBrandDto() {
		return brandDto;
	}

	public void setBrandDto(BrandDto brandDto) {
		this.brandDto = brandDto;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	


}
