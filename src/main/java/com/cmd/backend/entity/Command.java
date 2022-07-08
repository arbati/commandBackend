package com.cmd.backend.entity;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Command implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date orderDate;
	private Boolean valid;
	private String paymentMode;
	
	@ManyToOne
    private Customer customer;
    
	
	@OneToMany(mappedBy = "command",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Detail> details ;
	
	
	public Command() {}
	
	public Command( Date orderDate, Boolean valid, String paymentMode, Customer customer) {
		super();
		this.orderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customer = customer;
	}
	
	
	public Command(Long id, Date orderDate, Boolean valid, String paymentMode, Customer customer) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customer = customer;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	

	
	
	
	
	
}
