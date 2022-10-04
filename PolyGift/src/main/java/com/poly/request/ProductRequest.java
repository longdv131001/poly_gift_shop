package com.poly.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;

    private String image;

    private Double price;

    private Integer quantity;

    private String description;

    private Date createdDate;

    private Byte available;

    private Integer categoryId;

}
