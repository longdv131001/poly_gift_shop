package com.poly.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cart")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name = "username")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
