package com.nhnacademy.mooray.gateway.service.project;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.project.ProjectUpdateRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectCreationRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectResponse;

import java.util.List;

public interface ProjectService {

    MoorayResult<List<ProjectResponse>> findProjectsByUsername();

    MoorayResult<ProjectResponse> createProject(ProjectCreationRequest projectRequest);

    MoorayResult<ProjectResponse> updateProject(ProjectUpdateRequest projectRequest);
}
