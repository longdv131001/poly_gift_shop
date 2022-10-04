package com.poly.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderChangeRequest {
    private Byte status;

    private String note;

    private LocalDateTime createdDate;

    private String username;

    private Integer orderId;

}
