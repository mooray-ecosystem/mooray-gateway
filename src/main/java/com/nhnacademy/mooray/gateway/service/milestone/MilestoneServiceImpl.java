package com.nhnacademy.mooray.gateway.service.milestone;

import com.nhnacademy.mooray.gateway.dto.MoorayResult;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneCreationRequest;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneReponse;
import com.nhnacademy.mooray.gateway.dto.milestone.MilestoneUpdateRequest;
import com.nhnacademy.mooray.gateway.repository.milestone.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneRepository milestoneRepository;

    @Override
    public MoorayResult<MilestoneReponse> createMilestone(Long projectId, MilestoneCreationRequest milestoneRequest) {
        return milestoneRepository.createMilestone(projectId, milestoneRequest);
    }

    @Override
    public MoorayResult<List<MilestoneReponse>> retrieveMilestones(Long projectId) {
        return milestoneRepository.retrieveMilestones(projectId);
    }

    @Override
    public MoorayResult<MilestoneReponse> retrieveMilestone(Long projectId, Long milestoneId) {
        return milestoneRepository.retrieveMilestone(projectId, milestoneId);
    }

    @Override
    public MoorayResult<MilestoneReponse> updateMilestone(Long projectId, Long milestoneId,
                                                          MilestoneUpdateRequest milestoneRequest) {
        return milestoneRepository.updateMilestone(projectId, milestoneId, milestoneRequest);
    }

    @Override
    public MoorayResult<Boolean> deleteMilestone(Long projectId, Long milestoneId) {
        return milestoneRepository.deleteMilestone(projectId, milestoneId);
    }

}
