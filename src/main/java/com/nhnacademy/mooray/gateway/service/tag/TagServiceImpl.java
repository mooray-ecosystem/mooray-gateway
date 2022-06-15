package com.nhnacademy.mooray.gateway.service.tag;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.tag.TagCreationRequest;
import com.nhnacademy.mooray.gateway.dto.tag.TagReponse;
import com.nhnacademy.mooray.gateway.dto.tag.TagUpdateRequest;
import com.nhnacademy.mooray.gateway.repository.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public MoorayResult<TagReponse> createTag(Long projectId, TagCreationRequest tagRequest) {
        return tagRepository.createTag(projectId, tagRequest);
    }

    @Override
    public MoorayResult<List<TagReponse>> retrieveTags(Long projectId) {
        return tagRepository.retrieveTags(projectId);
    }

    @Override
    public MoorayResult<TagReponse> retrieveTag(Long projectId, Long tagId) {
        return tagRepository.retrieveTag(projectId, tagId);
    }

    @Override
    public MoorayResult<TagReponse> updateTag(Long projectId, Long tagId,
                                                          TagUpdateRequest tagRequest) {
        return tagRepository.updateTag(projectId, tagId, tagRequest);
    }

    @Override
    public MoorayResult<Boolean> deleteTag(Long projectId, Long tagId) {
        return tagRepository.deleteTag(projectId, tagId);
    }

}
