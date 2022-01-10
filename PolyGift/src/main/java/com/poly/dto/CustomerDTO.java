package com.poly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private Integer id;

	private String sdt;

	private LocalDate created_date;

	private String fullname;

	private String group;
}
