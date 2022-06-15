package com.nhnacademy.mooray.gateway.service.milestone;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneCreationRequest;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneReponse;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneUpdateRequest;

import java.util.List;

public interface MilestoneService {

    MoorayResult<MilestoneReponse> createMilestone(Long projectId, MilestoneCreationRequest milestoneRequest);

    MoorayResult<List<MilestoneReponse>> retrieveMilestones(Long projectId);

    MoorayResult<MilestoneReponse> retrieveMilestone(Long projectId, Long milestoneId);

    MoorayResult<MilestoneReponse> updateMilestone(Long projectId, Long milestoneId,
                                                   MilestoneUpdateRequest milestoneRequest);

    MoorayResult<Boolean> deleteMilestone(Long projectId, Long milestoneId);

}
