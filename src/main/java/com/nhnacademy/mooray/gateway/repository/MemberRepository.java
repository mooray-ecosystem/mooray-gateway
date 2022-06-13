package com.nhnacademy.mooray.gateway.repository;

import com.nhnacademy.mooray.gateway.dto.MemberJoinRequest;

public interface MemberRepository {

    String signUp(MemberJoinRequest polishedMemberRequest);

}
