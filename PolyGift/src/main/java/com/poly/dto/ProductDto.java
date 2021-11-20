package com.poly.dto;

import java.util.Date;

import com.poly.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    Integer Id;
	String Name;
	String Image;
	Double Price;
	Boolean Available;
	Date CreateDate = new Date();
	Category category;

//	List<OrderDetailDto> orderDetailsDto;
}
