package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Products")
public class Product  implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private String Image;
	private Double Price;
	private Integer Quantity;
	private String Description;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")
	private Date CreateDate;
	private boolean Available;
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Cart> cart;
}
