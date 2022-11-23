package com.sinem.mapper;

import com.sinem.dto.request.*;
import com.sinem.dto.response.CandidateStatusResponseDto;
import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.CandidateDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICandidateMapper {
    ICandidateMapper INSTANCE = Mappers.getMapper(ICandidateMapper.class);

    Candidate toCandidate(final DeleteCandidateDto deleteCandidateDto);
    Candidate toCandidate(final SaveCandidateDto saveCandidateDto);
    Candidate toCandidate(final UpdateCandidateDto updateCandidateDto);
    Candidate toCandidate(final CandidateStatusResponseDto statusResponseDto);
    CandidateStatusResponseDto toCandidateStatusResponseDto (final Candidate candidate);
    CandidateDetail toCandidateDetail(final SaveCandidateDetailDto saveCandidateDetailDto);
    CandidateDetail toCandidateDetail(final UpdateCandidateDetailDto updateCandidateDetailDto);
    CandidateDetail toCandidateDetail(final DeleteCandidateDetailDto deleteCandidateDetailDto);

}
