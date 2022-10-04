package com.poly.response;

import lombok.Data;

@Data
public class CartResponse {
    private Integer id;
    private ProductResponse product;
    private Integer quantity;
}
