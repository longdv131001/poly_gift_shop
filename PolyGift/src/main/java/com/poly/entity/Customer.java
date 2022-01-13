package com.poly.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "customer")

public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="sdt_customer")
	private String sdt;
	
	@Column(name="created_date")
	private LocalDate createdDate;


	@Column(name="fullname")
	private String fullname;

	@Column(name="group_customer")
	private String group;
}
