package com.nhnacademy.mooray.gateway.service.task;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.task.TaskReponse;
import com.nhnacademy.mooray.gateway.dto.task.TaskCreationRequest;
import com.nhnacademy.mooray.gateway.dto.task.TaskUpdateRequest;
import com.nhnacademy.mooray.gateway.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public MoorayResult<TaskReponse> createTask(Long projectId, TaskCreationRequest taskRequest) {
        return taskRepository.createTask(projectId, taskRequest);
    }

    @Override
    public MoorayResult<List<TaskReponse>> retrieveTasks(Long projectId) {
        return taskRepository.retrieveTasks(projectId);
    }

    @Override
    public MoorayResult<TaskReponse> retrieveTask(Long projectId, Long taskId) {
        return taskRepository.retrieveTask(projectId, taskId);
    }

    @Override
    public MoorayResult<TaskReponse> updateTask(Long projectId, Long taskId, TaskUpdateRequest taskRequest) {
        return taskRepository.updateTask(projectId, taskId, taskRequest);
    }

    @Override
    public MoorayResult<Boolean> deleteTask(Long projectId, Long taskId) {
        return taskRepository.deleteTask(projectId, taskId);
    }

}
