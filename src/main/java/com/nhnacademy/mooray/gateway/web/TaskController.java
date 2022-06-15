package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.task.TaskReponse;
import com.nhnacademy.mooray.gateway.dto.task.TaskCreationRequest;
import com.nhnacademy.mooray.gateway.dto.task.TaskUpdateRequest;
import com.nhnacademy.mooray.gateway.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/projects/{project-id}/tasks")
    public ModelAndView createTask(@PathVariable("project-id") Long projectId,
                                   @Valid @ModelAttribute TaskCreationRequest taskRequest) {

        ModelAndView mav = new ModelAndView("tasks/index");

        MoorayResult<TaskReponse> result = taskService.createTask(projectId, taskRequest);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/tasks")
    public ModelAndView retrieveTasks(@PathVariable("project-id") Long projectId) {
        ModelAndView mav = new ModelAndView("tasks/index");

        MoorayResult<List<TaskReponse>> result = taskService.retrieveTasks(projectId);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/tasks/{task-id}")
    public ModelAndView retrieveTask(@PathVariable("project-id") Long projectId,
                                     @PathVariable("task-id") Long taskId) {

        ModelAndView mav = new ModelAndView("tasks/index");

        MoorayResult<TaskReponse> result = taskService.retrieveTask(projectId, taskId);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/tasks/{task-id}/update")
    public ModelAndView updateTask(@PathVariable("project-id") Long projectId,
                                   @PathVariable("task-id") Long taskId,
                                   @Valid @ModelAttribute TaskUpdateRequest taskRequest) {

        ModelAndView mav = new ModelAndView("tasks/update");

        MoorayResult<TaskReponse> result = taskService.updateTask(projectId, taskId, taskRequest);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/tasks/{task-id}/delete")
    public ModelAndView deleteTask(@PathVariable("project-id") Long projectId,
                                   @PathVariable("task-id") Long taskId) {

        ModelAndView mav = new ModelAndView("tasks/update");

        MoorayResult<Boolean> result = taskService.deleteTask(projectId, taskId);
        mav.addObject("result", result);

        return mav;
    }

}
