package com.poly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Integer id;
	private Double price;
	private Integer quantity;
	private ProductDto productDto;
	private OrderDto orderDto;
}
