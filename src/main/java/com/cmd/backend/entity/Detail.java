package com.cmd.backend.entity;


import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Detail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
    private Product product;
	
	@ManyToOne
	@JoinColumn(name = "command_id")
	private Command command;
    
	
	public Detail() {}

	
	public Detail(Integer quantity, Product product, Command command) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.command = command;
	}

	
	public Detail(Long id, Integer quantity, Product product, Command command) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.command = command;
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


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Command getCommand() {
		return command;
	}


	public void setCommand(Command command) {
		this.command = command;
	}

	
	
	
	
}
