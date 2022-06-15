package com.nhnacademy.mooray.gateway.service.account;

import com.nhnacademy.mooray.gateway.dto.account.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.dto.account.MemberLoginRequest;

public interface MemberService {

    String signUp(MemberJoinRequest memberRequest);

    String login(MemberLoginRequest memberRequest);

}
