package com.nhnacademy.mooray.gateway.service;

import com.nhnacademy.mooray.gateway.dto.MemberJoinRequest;

public interface MemberService {

    String signUp(MemberJoinRequest memberRequest);

}
