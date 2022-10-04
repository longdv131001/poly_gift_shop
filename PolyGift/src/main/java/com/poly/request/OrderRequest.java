package com.poly.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String address;

    private String username;

    private String phoneNumber;

    private String fullName;

    // 0:Đang chờ xác nhận , 1:Đã hủy , 2:Đang giao , 3:Giao hàng thành công
    private Byte orderStatus;

    private String noteCustomer;

    private Long total;

    private Long fee;

    private String city;

    private String districts;

    private String wards;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String orderCode;

}
