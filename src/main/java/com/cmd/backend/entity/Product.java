package com.cmd.backend.entity;


import java.util.List;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	private String photo;
	private String designation;
	private Double price;
	private Integer depositQuantity;
	private Date expirationDate;
	private String shortDescription;
	private String fullDescription;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Detail> details;
	
	/*
	@ManyToMany(mappedBy = "orderDetail")
	private List<Command> orders;
	 */
	
	public Product(){};
	
	
	public Product(String photo, String designation, Double price, Integer depositQuantity,
			Date expirationDate, String shortDescription, String fullDescription, Category category, Brand brand) {
		super();
		this.photo = photo;
		this.designation = designation;
		this.price = price;
		this.depositQuantity = depositQuantity;
		this.expirationDate = expirationDate;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.category = category;
		this.brand = brand;
	}
	
	
	public Product(Long id, String photo, String designation, Double price, Integer depositQuantity,
			Date expirationDate, String shortDescription, String fullDescription, Category category, Brand brand) {
		super();
		this.id = id;
		this.photo = photo;
		this.designation = designation;
		this.price = price;
		this.depositQuantity = depositQuantity;
		this.expirationDate = expirationDate;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.category = category;
		this.brand = brand;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	
	
	


}
