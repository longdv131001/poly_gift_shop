package com.poly.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

	private Integer id;

	private String phoneNumber;

	private LocalDate createdDate;

	private String fullName;

	private String group;
}
