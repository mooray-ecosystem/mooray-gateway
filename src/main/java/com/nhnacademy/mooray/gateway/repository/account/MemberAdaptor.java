package com.nhnacademy.mooray.gateway.repository.account;

import com.nhnacademy.mooray.gateway.dto.account.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.dto.account.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
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
    public String signUp(MemberJoinRequest polishedMemberRequest) {
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MemberJoinRequest> requestEntity = new HttpEntity<>(polishedMemberRequest, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8888/members/signup",
                                                                      POST,
                                                                      requestEntity,
                                                                      String.class);

        return responseEntity.getBody();
    }

    @Override
    public String login(MemberLoginRequest memberRequest) {
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MemberLoginRequest> requestEntity = new HttpEntity<>(memberRequest, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8888/members/login",
                                                                      POST,
                                                                      requestEntity,
                                                                      String.class);

        return responseEntity.getBody();
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(username, headers);

        ResponseEntity<Optional<Member>> responseEntity = restTemplate.exchange("http://localhost:8888/members/login",
                                                                                POST,
                                                                                requestEntity,
                                                                                new ParameterizedTypeReference<>() {
                                                                                });

        return responseEntity.getBody();
    }

}
