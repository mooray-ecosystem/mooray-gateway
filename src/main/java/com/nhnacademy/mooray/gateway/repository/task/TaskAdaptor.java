package com.nhnacademy.mooray.gateway.repository.task;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.task.TaskReponse;
import com.nhnacademy.mooray.gateway.dto.task.TaskCreationRequest;
import com.nhnacademy.mooray.gateway.dto.task.TaskUpdateRequest;
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
public class TaskAdaptor implements TaskRepository {

    private final RestTemplate restTemplate;

    @Override
    public MoorayResult<TaskReponse> createTask(Long projectId, TaskCreationRequest taskRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<TaskCreationRequest> requestEntity = new HttpEntity<>(taskRequest, headers);

        ResponseEntity<MoorayResult<TaskReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tasks",
                                        POST,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<List<TaskReponse>> retrieveTasks(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<List<TaskReponse>>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tasks",
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<TaskReponse> retrieveTask(Long projectId, Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<TaskReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tasks/" + taskId,
                                        GET,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();

    }

    @Override
    public MoorayResult<TaskReponse> updateTask(Long projectId, Long taskId, TaskUpdateRequest taskRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<TaskUpdateRequest> requestEntity = new HttpEntity<>(taskRequest, headers);

        ResponseEntity<MoorayResult<TaskReponse>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tasks/" + taskId,
                                        PUT,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

    @Override
    public MoorayResult<Boolean> deleteTask(Long projectId, Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MoorayResult<Boolean>> responseEntity
                = restTemplate.exchange("http://localhost:9999/projects/" + projectId + "/tasks/" + taskId,
                                        DELETE,
                                        requestEntity,
                                        new ParameterizedTypeReference<>() {
                                        });

        return responseEntity.getBody();
    }

}
