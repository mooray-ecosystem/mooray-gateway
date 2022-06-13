package com.nhnacademy.mooray.gateway.repository;

import com.nhnacademy.mooray.gateway.dto.MemberSignUpRequest;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberRepository {

    String signUp(MemberSignUpRequest polishedMemberRequest);

    Optional<Member> findByEmail();

}
