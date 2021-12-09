package com.poly.dto;

import lombok.Data;

@Data
public class CartDTO {
	private Integer id;
	private ProductDto product;
	private Integer quantity;
}
