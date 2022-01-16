package com.poly.dto;

import com.poly.entity.Account;
import com.poly.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderChangeDTO {
	private Integer id;

	private Integer status;

	private String note;

	private LocalDateTime createdDate;

	private AccountDto account;

	private OrderDto order;
}
