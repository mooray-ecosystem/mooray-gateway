package com.nhnacademy.mooray.gateway.service;

import com.nhnacademy.mooray.gateway.dto.MemberSignUpRequest;
import com.nhnacademy.mooray.gateway.dto.MemberLoginRequest;
import org.springframework.http.ResponseEntity;

public interface MemberService {

    String signUp(MemberSignUpRequest memberRequest);

    ResponseEntity<?> login(MemberLoginRequest memberRequest);

}
