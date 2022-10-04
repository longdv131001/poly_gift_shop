package com.poly.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderChangeResponse {
    private Integer id;

    private Integer status;

    private String note;

    private LocalDateTime createdDate;

    private AccountResponse account;

    private OrderResponse order;
}
