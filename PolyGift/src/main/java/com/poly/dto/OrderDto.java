package com.poly.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    Long id;
	String address;
	Date createDate;
	AccountDto accountDto;
	List<OrderDetailDto> orderDetailDtoList; ///
}
