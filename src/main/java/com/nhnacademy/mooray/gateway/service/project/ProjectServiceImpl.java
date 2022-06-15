package com.nhnacademy.mooray.gateway.service.project;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.project.ProjectCreationRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectResponse;
import com.nhnacademy.mooray.gateway.dto.project.ProjectUpdateRequest;
import com.nhnacademy.mooray.gateway.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public MoorayResult<List<ProjectResponse>> findProjectsByUsername() {
        return projectRepository.findProjectsByUsername();
    }

    @Override
    public MoorayResult<ProjectResponse> createProject(ProjectCreationRequest projectRequest) {
        return projectRepository.createProject(projectRequest);
    }

    @Override
    public MoorayResult<ProjectResponse> updateProject(ProjectUpdateRequest projectRequest) {
        return projectRepository.updateProject(projectRequest);
    }

}
