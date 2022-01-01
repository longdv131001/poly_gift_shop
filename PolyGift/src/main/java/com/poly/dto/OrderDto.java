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
	private AccountDto accountDto;
	private String fullname;
	private String note;
	private Float total;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private Integer orderStatus;
}
