package com.nhnacademy.mooray.gateway.repository.project;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.project.ProjectCreationRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectResponse;
import com.nhnacademy.mooray.gateway.dto.project.ProjectUpdateRequest;

import java.util.List;

public interface ProjectRepository {

    MoorayResult<List<ProjectResponse>> findProjectsByUsername();

    MoorayResult<ProjectResponse> createProject(ProjectCreationRequest projectRequest);

    MoorayResult<ProjectResponse> updateProject(ProjectUpdateRequest projectRequest);

}
