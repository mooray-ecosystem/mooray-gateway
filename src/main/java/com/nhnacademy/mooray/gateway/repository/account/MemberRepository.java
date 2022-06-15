package com.nhnacademy.mooray.gateway.repository.account;

import com.nhnacademy.mooray.gateway.dto.account.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.dto.account.MemberLoginRequest;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberRepository {

    String signUp(MemberJoinRequest polishedMemberRequest);

    String login(MemberLoginRequest memberRequest);

    Optional<Member> findByUsername(String username);

}
