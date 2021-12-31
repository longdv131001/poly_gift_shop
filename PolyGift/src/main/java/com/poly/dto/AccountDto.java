package com.poly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private boolean isDisable;

}
