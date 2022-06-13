package com.nhnacademy.mooray.gateway.service;

import com.nhnacademy.mooray.gateway.dto.MemberSignUpRequest;
import com.nhnacademy.mooray.gateway.dto.MemberLoginRequest;
import com.nhnacademy.mooray.gateway.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String signUp(MemberSignUpRequest memberRequest) {
        String hashedPassword = passwordEncoder.encode(memberRequest.getPassword());
        MemberSignUpRequest polishedMemberRequest = MemberSignUpRequest.polish(memberRequest, hashedPassword);

        return memberRepository.signUp(polishedMemberRequest);
    }

    @Override
    public ResponseEntity<?> login(MemberLoginRequest memberRequest) {
        // ResponseEntity response = new ResponseEntity<>();
        // if (!memberRepository.findByEmail().isPresent()) {
        //     return response.fail("")
        // }
        return null;
    }

}
