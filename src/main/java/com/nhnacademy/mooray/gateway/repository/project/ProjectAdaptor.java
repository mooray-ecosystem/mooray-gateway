package com.nhnacademy.mooray.gateway.repository.project;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.project.ProjectCreationRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectResponse;
import com.nhnacademy.mooray.gateway.dto.project.ProjectUpdateRequest;
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
public class ProjectAdaptor implements ProjectRepository {

    private final RestTemplate restTemplate;

    @Override
    public MoorayResult<List<ProjectResponse>> findProjectsByUsername() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<MoorayResult<ProjectResponse>> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<List<ProjectResponse>>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects",
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<ProjectResponse> createProject(ProjectCreationRequest projectRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<ProjectCreationRequest> requestEntity = new HttpEntity<>(projectRequest, headers);

        ResponseEntity<MoorayResult<ProjectResponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects",
                                        POST,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<ProjectResponse> updateProject(ProjectUpdateRequest projectRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<ProjectUpdateRequest> requestEntity = new HttpEntity<>(projectRequest, headers);

        ResponseEntity<MoorayResult<ProjectResponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects",
                                        PUT,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

}
