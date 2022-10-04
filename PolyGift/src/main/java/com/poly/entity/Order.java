package com.poly.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "order_status") // 0:Đang chờ xác nhận , 1:Đã hủy , 2:Đang giao , 3:Giao hàng thành công
    private Byte orderStatus;

    @Column(name = "note_customer")
    private String noteCustomer;

    @Column(name = "total")
    private Long total;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "city")
    private String city;

    @Column(name = "districts")
    private String districts;

    @Column(name = "wards")
    private String wards;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "order_code")
    private String orderCode;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    private List<OrderChange> orderChanges;
}
