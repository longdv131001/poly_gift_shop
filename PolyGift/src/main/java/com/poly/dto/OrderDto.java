package com.poly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
	private String address;
	private String sdt;
	private AccountDto account;
	private String fullname;
	private String noteCustomer;
	private Float total;
	private Float fee;
	private String city;
	private String districts;
	private String wards;
	private String orderCode;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private Integer orderStatus;
}
