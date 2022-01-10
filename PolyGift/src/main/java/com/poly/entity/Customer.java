package com.poly.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="sdt")
	private String sdt;
	
	@Column(name="created_date")
	private LocalDate created_date;
	
	@Column(name="fullname")
	private String fullname;

	@Column(name="group")
	private String group;
}
