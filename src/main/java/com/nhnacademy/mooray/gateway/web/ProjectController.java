package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.project.ProjectCreationRequest;
import com.nhnacademy.mooray.gateway.dto.project.ProjectResponse;
import com.nhnacademy.mooray.gateway.dto.project.ProjectUpdateRequest;
import com.nhnacademy.mooray.gateway.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects")
    public ModelAndView retrieveProjects() {
        ModelAndView mav = new ModelAndView("projects/index");
        return mav;
    }

    @PostMapping("/projects/create")
    public MoorayResult<ProjectResponse> createProject(@Valid @ModelAttribute ProjectCreationRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }

    @PostMapping("/projects/update")
    public MoorayResult<ProjectResponse> updateProject(@Valid @ModelAttribute ProjectUpdateRequest projectRequest) {
        return projectService.updateProject(projectRequest);
    }

}
