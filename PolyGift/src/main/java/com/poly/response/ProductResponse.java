package com.poly.response;

import com.poly.request.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	private Integer id;
	private String name;
	private String image;
	private Double price;
	private Integer available;
	private Date createDate;
	private Integer quantity;
	private String description;
	private CategoryResponse category;


}
