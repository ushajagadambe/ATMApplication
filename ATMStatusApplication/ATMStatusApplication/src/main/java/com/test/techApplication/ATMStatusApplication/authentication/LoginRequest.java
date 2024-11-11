package com.test.techApplication.ATMStatusApplication.authentication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
