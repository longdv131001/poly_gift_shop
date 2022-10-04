package com.poly.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    private String username;

    private String password;

    private String fullName;

    private String email;

    private boolean isDisable;

}
