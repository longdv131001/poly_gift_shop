package com.poly.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequest {

    private String phoneNumber;

    private LocalDate createdDate;

    private String fullName;

    private String group;
}
