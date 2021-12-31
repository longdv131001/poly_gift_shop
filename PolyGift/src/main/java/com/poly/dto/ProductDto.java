package com.poly.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private Integer Id;
	private String Name;
	private String Image;
	private Double Price;
	private Integer Available;
	private Date CreateDate;
	private Integer Quantity;
	private String Description;
	private CategoryDto category;


}
