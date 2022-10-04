package com.poly.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountResponse {
    private String username;
    private String fullName;
    private String email;
    private boolean isDisable;

}
