package com.nhnacademy.mooray.gateway.repository.task;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.task.TaskReponse;
import com.nhnacademy.mooray.gateway.dto.task.TaskCreationRequest;
import com.nhnacademy.mooray.gateway.dto.task.TaskUpdateRequest;

import java.util.List;

public interface TaskRepository {

    MoorayResult<TaskReponse> createTask(Long projectId, TaskCreationRequest taskRequest);

    MoorayResult<List<TaskReponse>> retrieveTasks(Long projectId);

    MoorayResult<TaskReponse> retrieveTask(Long projectId, Long taskId);

    MoorayResult<TaskReponse> updateTask(Long projectId, Long taskId, TaskUpdateRequest taskRequest);

    MoorayResult<Boolean> deleteTask(Long projectId, Long taskId);

}
