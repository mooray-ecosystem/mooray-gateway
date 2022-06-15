package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneCreationRequest;
import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneReponse;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneUpdateRequest;
import com.nhnacademy.mooray.gateway.service.milestone.MilestoneService;
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
public class MilestoneController {

    private final MilestoneService milestoneService;

    @PostMapping("/projects/{project-id}/milestones")
    public ModelAndView createMilestone(@PathVariable("project-id") Long projectId,
                                   @Valid @ModelAttribute MilestoneCreationRequest milestoneRequest) {

        ModelAndView mav = new ModelAndView("milestones/index");

        MoorayResult<MilestoneReponse> result = milestoneService.createMilestone(projectId, milestoneRequest);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/milestones")
    public ModelAndView retrieveMilestones(@PathVariable("project-id") Long projectId) {
        ModelAndView mav = new ModelAndView("milestones/index");

        MoorayResult<List<MilestoneReponse>> result = milestoneService.retrieveMilestones(projectId);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/milestones/{milestone-id}")
    public ModelAndView retrieveMilestone(@PathVariable("project-id") Long projectId,
                                     @PathVariable("milestone-id") Long milestoneId) {

        ModelAndView mav = new ModelAndView("milestones/index");

        MoorayResult<MilestoneReponse> result = milestoneService.retrieveMilestone(projectId, milestoneId);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/milestones/{milestone-id}/update")
    public ModelAndView updateMilestone(@PathVariable("project-id") Long projectId,
                                   @PathVariable("milestone-id") Long milestoneId,
                                   @Valid @ModelAttribute MilestoneUpdateRequest milestoneRequest) {

        ModelAndView mav = new ModelAndView("milestones/update");

        MoorayResult<MilestoneReponse> result = milestoneService.updateMilestone(projectId, milestoneId, milestoneRequest);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/milestones/{milestone-id}/delete")
    public ModelAndView deleteMilestone(@PathVariable("project-id") Long projectId,
                                   @PathVariable("milestone-id") Long milestoneId) {

        ModelAndView mav = new ModelAndView("milestones/update");

        MoorayResult<Boolean> result = milestoneService.deleteMilestone(projectId, milestoneId);
        mav.addObject("result", result);

        return mav;
    }

}
