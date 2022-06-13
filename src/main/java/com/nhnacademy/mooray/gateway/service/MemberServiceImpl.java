package com.nhnacademy.mooray.gateway.service;

import com.nhnacademy.mooray.gateway.dto.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String signUp(MemberJoinRequest memberRequest) {
        String hashedPassword = passwordEncoder.encode(memberRequest.getPassword());
        MemberJoinRequest polishedMemberRequest = MemberJoinRequest.polish(memberRequest, hashedPassword);

        return memberRepository.signUp(polishedMemberRequest);
    }


}
