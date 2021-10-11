package com.polygift.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    Long id;
	Double price;
	Integer quantity;
	ProductDto productDto;
	OrderDto orderDto;
}
