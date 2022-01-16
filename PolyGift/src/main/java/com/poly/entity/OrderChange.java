package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "OrderChange")
public class OrderChange implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Id")
		private Integer id;
		
		@Column(name="status")
		private Integer status;

		@Column(name = "note")
		private String note;

		@Column(name = "created_date")
		private LocalDateTime createdDate;

		@ManyToOne
		@JoinColumn(name = "username")
		private Account account;

		@ManyToOne
		@JoinColumn(name= "order_id")
		private Order order;

}
