package com.cmd.backend.entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date OrderDate;
	private Boolean valid;
	private String paymentMode;
	
	@ManyToOne
    private Customer customer;
    
    @ManyToMany
    @JoinTable(
      name = "order_detail", 
      joinColumns = @JoinColumn(name = "order_id"), 
      inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> orderDetail=new ArrayList<>();
    
	
	
	public Command() {}
	
	public Command( Date orderDate, Boolean valid, String paymentMode, Customer customer,
			List<Product> orderDetail) {
		super();
		OrderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customer = customer;
		this.orderDetail = orderDetail;
	}
	
	
	public Command(Long id, Date orderDate, Boolean valid, String paymentMode, Customer customer,
			List<Product> orderDetail) {
		super();
		this.id = id;
		OrderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customer = customer;
		this.orderDetail = orderDetail;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<Product> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	public void addProduct(Product prd) {
		
		orderDetail.add(prd);
		
	}
	
	
	
	
	
}
