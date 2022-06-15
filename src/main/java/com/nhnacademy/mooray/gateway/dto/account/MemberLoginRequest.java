package com.nhnacademy.mooray.gateway.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginRequest {

    private final String username;
    private final String password;

}
