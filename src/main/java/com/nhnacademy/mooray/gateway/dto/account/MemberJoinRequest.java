package com.nhnacademy.mooray.gateway.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
// NOTE: 비밀번호 인코딩 처리를 위함
@Getter
public class MemberJoinRequest {

    private final String username;
    private final String password;
    private final String emailAddress;
    private final String authority;

    public static MemberJoinRequest polish(MemberJoinRequest memberRequest, String hashedPassword) {
        return new MemberJoinRequest(memberRequest.username,
                                     hashedPassword,
                                     memberRequest.emailAddress,
                                     memberRequest.getAuthority());
    }

}
