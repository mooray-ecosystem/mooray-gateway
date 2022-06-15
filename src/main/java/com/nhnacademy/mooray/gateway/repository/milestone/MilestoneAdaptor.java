package com.nhnacademy.mooray.gateway.repository.milestone;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneCreationRequest;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneReponse;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class MilestoneAdaptor implements MilestoneRepository {

    private final RestTemplate restTemplate;

    @Override
    public MoorayResult<MilestoneReponse> createMilestone(Long projectId, MilestoneCreationRequest milestoneRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MilestoneCreationRequest> requestEntity = new HttpEntity<>(milestoneRequest, headers);

        ResponseEntity<MoorayResult<MilestoneReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/milestones",
                                        POST,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<List<MilestoneReponse>> retrieveMilestones(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<List<MilestoneReponse>>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/milestones",
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<MilestoneReponse> retrieveMilestone(Long projectId, Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<MilestoneReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/milestones/" + milestoneId,
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<MilestoneReponse> updateMilestone(Long projectId, Long milestoneId,
                                                          MilestoneUpdateRequest milestoneRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MilestoneUpdateRequest> requestEntity = new HttpEntity<>(milestoneRequest, headers);

        ResponseEntity<MoorayResult<MilestoneReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/milestones/" + milestoneId,
                                        PUT,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<Boolean> deleteMilestone(Long projectId, Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<Boolean>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/milestones/" + milestoneId,
                                        DELETE,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

}
