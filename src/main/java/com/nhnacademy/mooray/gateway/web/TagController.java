package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.tag.TagCreationRequest;
import com.nhnacademy.mooray.gateway.dto.tag.TagReponse;
import com.nhnacademy.mooray.gateway.dto.tag.TagUpdateRequest;
import com.nhnacademy.mooray.gateway.service.tag.TagService;
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
public class TagController {

    private final TagService tagService;

    @PostMapping("/projects/{project-id}/tags")
    public ModelAndView createTag(@PathVariable("project-id") Long projectId,
                                   @Valid @ModelAttribute TagCreationRequest tagRequest) {

        ModelAndView mav = new ModelAndView("tags/index");

        MoorayResult<TagReponse> result = tagService.createTag(projectId, tagRequest);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/tags")
    public ModelAndView retrieveTags(@PathVariable("project-id") Long projectId) {
        ModelAndView mav = new ModelAndView("tags/index");

        MoorayResult<List<TagReponse>> result = tagService.retrieveTags(projectId);
        mav.addObject("result", result);

        return mav;
    }

    @GetMapping("/projects/{project-id}/tags/{tag-id}")
    public ModelAndView retrieveTag(@PathVariable("project-id") Long projectId,
                                     @PathVariable("tag-id") Long tagId) {

        ModelAndView mav = new ModelAndView("tags/index");

        MoorayResult<TagReponse> result = tagService.retrieveTag(projectId, tagId);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/tags/{tag-id}/update")
    public ModelAndView updateTag(@PathVariable("project-id") Long projectId,
                                   @PathVariable("tag-id") Long tagId,
                                   @Valid @ModelAttribute TagUpdateRequest tagRequest) {

        ModelAndView mav = new ModelAndView("tags/update");

        MoorayResult<TagReponse> result = tagService.updateTag(projectId, tagId, tagRequest);
        mav.addObject("result", result);

        return mav;
    }

    @PostMapping("/projects/{project-id}/tags/{tag-id}/delete")
    public ModelAndView deleteTag(@PathVariable("project-id") Long projectId,
                                   @PathVariable("tag-id") Long tagId) {

        ModelAndView mav = new ModelAndView("tags/update");

        MoorayResult<Boolean> result = tagService.deleteTag(projectId, tagId);
        mav.addObject("result", result);

        return mav;
    }

}
