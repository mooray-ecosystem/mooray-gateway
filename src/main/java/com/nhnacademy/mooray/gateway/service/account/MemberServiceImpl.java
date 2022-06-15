package com.nhnacademy.mooray.gateway.service.account;

import com.nhnacademy.mooray.gateway.dto.account.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.dto.account.MemberLoginRequest;
import com.nhnacademy.mooray.gateway.repository.account.MemberRepository;
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

    @Override
    public String login(MemberLoginRequest memberRequest) {
        boolean matches = passwordEncoder.matches(memberRequest.getPassword(),
                                                  passwordEncoder.encode(memberRequest.getPassword()));
        return memberRepository.login(memberRequest);
    }

}
