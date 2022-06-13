package com.nhnacademy.mooray.gateway.repository;

import com.nhnacademy.mooray.gateway.dto.MemberSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class MemberAdaptor implements MemberRepository {

    private final RestTemplate restTemplate;

    @Override
    public String signUp(MemberSignUpRequest polishedMemberRequest) {
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MemberSignUpRequest> requestEntity = new HttpEntity<>(polishedMemberRequest, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8888/members",
                                                                      POST,
                                                                      requestEntity,
                                                                      String.class);

        return responseEntity.getBody();
    }

    @Override
    public Optional<Member> findByEmail() {
        return Optional.empty();
    }

}
