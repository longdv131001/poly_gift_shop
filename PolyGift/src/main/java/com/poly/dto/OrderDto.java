package com.poly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
	private String address;
	private String sdt;
	private AccountDto accountDto;
	
}
