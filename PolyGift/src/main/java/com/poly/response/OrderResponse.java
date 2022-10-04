package com.poly.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Integer id;
    private String address;
    private String sdt;
    private AccountResponse account;
    private String fullName;
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
