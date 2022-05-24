package com.cmd.backend.dto;

import java.io.Serializable;
import java.util.Date;



public class CommandDto implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long id;
	private Date OrderDate;
	private Boolean valid;
	private String paymentMode;
	
	private CustomerDto customerDto;
	
	
	public CommandDto() {}
	
	public CommandDto( Date orderDate, Boolean valid, String paymentMode,CustomerDto customerDto) {
		super();
		OrderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customerDto=customerDto;
		}
	
	
	public CommandDto(Long id, Date orderDate, Boolean valid, String paymentMode,CustomerDto customerDto) {
		super();
		this.id = id;
		OrderDate = orderDate;
		this.valid = valid;
		this.paymentMode = paymentMode;
		this.customerDto=customerDto;
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

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	
	
	
}
