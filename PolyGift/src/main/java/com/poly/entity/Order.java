package com.poly.entity;

import java.io.Serializable;
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
@Table(name = "Orders")
public class Order implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Id")
		private Integer id;
		
		@Column(name="Address")
		private String address;
		@Temporal(TemporalType.DATE)
	
		@ManyToOne
		@JoinColumn(name = "Username")
		private Account account;
		
		@Column(name="Sdt")
		private String sdt;

		@Column(name="fullname")
		private String fullname;

		@JsonIgnore
		@OneToMany(mappedBy = "order")
		private List<OrderDetail> orderDetails;
}
