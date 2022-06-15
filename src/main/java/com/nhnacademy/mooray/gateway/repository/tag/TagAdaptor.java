package com.nhnacademy.mooray.gateway.repository.tag;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.tag.TagCreationRequest;
import com.nhnacademy.mooray.gateway.dto.tag.TagReponse;
import com.nhnacademy.mooray.gateway.dto.tag.TagUpdateRequest;
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
public class TagAdaptor implements TagRepository {

    private final RestTemplate restTemplate;

    @Override
    public MoorayResult<TagReponse> createTag(Long projectId, TagCreationRequest tagRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<TagCreationRequest> requestEntity = new HttpEntity<>(tagRequest, headers);

        ResponseEntity<MoorayResult<TagReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tags",
                                        POST,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<List<TagReponse>> retrieveTags(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<List<TagReponse>>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tags",
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<TagReponse> retrieveTag(Long projectId, Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<TagReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tags/" + tagId,
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<TagReponse> updateTag(Long projectId, Long tagId,
                                              TagUpdateRequest tagRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<TagUpdateRequest> requestEntity = new HttpEntity<>(tagRequest, headers);

        ResponseEntity<MoorayResult<TagReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tags/" + tagId,
                                        PUT,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<Boolean> deleteTag(Long projectId, Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<Boolean>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tags/" + tagId,
                                        DELETE,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

}
