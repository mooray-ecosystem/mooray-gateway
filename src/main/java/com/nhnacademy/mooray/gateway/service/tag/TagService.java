package com.nhnacademy.mooray.gateway.service.tag;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.tag.TagCreationRequest;
import com.nhnacademy.mooray.gateway.dto.tag.TagReponse;
import com.nhnacademy.mooray.gateway.dto.tag.TagUpdateRequest;

import java.util.List;

public interface TagService {

    MoorayResult<TagReponse> createTag(Long projectId, TagCreationRequest tagRequest);

    MoorayResult<List<TagReponse>> retrieveTags(Long projectId);

    MoorayResult<TagReponse> retrieveTag(Long projectId, Long tagId);

    MoorayResult<TagReponse> updateTag(Long projectId, Long tagId, TagUpdateRequest tagRequest);

    MoorayResult<Boolean> deleteTag(Long projectId, Long tagId);

}
