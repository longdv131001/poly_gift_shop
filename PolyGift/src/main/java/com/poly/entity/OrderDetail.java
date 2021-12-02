package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Orderdetails")
public class OrderDetail  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="Id")
	private Integer id;
	
	@Column(name= "Price")
	private Float price;
	
	@Column(name= "Quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Order order;
}
