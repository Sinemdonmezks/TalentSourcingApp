package com.sinem.service;

import com.sinem.dto.request.DeleteCandidateDetailDto;
import com.sinem.dto.request.SaveCandidateDetailDto;
import com.sinem.dto.request.UpdateCandidateDetailDto;
import com.sinem.exception.CandidateServiceException;
import com.sinem.exception.ErrorType;
import com.sinem.mapper.ICandidateMapper;
import com.sinem.repository.ICandidateDetailRepository;
import com.sinem.repository.ICandidateRepository;
import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.CandidateDetail;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateDetailService extends ServiceManager<CandidateDetail, Long> {
    private final ICandidateDetailRepository candidateDetailRepository;
    private final ICandidateRepository candidateRepository;

    public CandidateDetailService(ICandidateDetailRepository candidateDetailRepository,
                                  ICandidateRepository candidateRepository) {
        super(candidateDetailRepository);
        this.candidateDetailRepository = candidateDetailRepository;
        this.candidateRepository = candidateRepository;
    }

    public CandidateDetail save(SaveCandidateDetailDto saveCandidateDetailDto) {
        Optional<Candidate> candidate = candidateRepository.findOptionalById(saveCandidateDetailDto.getCandidateId());
        CandidateDetail candidateDetail = ICandidateMapper.INSTANCE.toCandidateDetail(saveCandidateDetailDto);
              if (candidate.isPresent()) {
            return candidateDetailRepository.save(candidateDetail);

        } else {
           throw new CandidateServiceException(ErrorType.CANDIDATE_NOT_FOUND);
        }

    }

    public CandidateDetail update(UpdateCandidateDetailDto updateCandidateDetailDto) {
        Optional<CandidateDetail> candidateDetail = candidateDetailRepository.findOptionalByCandidateId(updateCandidateDetailDto.getCandidateId());
        //CandidateDetail candidateDetail = ICandidateMapper.INSTANCE.toCandidateDetail(updateCandidateDetailDto);
        if (candidateDetail.isPresent()) {
            candidateDetail.get().setContent(updateCandidateDetailDto.getContent());
            candidateDetail.get().setDate(updateCandidateDetailDto.getDate());
            candidateDetail.get().setType(updateCandidateDetailDto.getType());
            candidateDetail.get().setCandidateResponded(updateCandidateDetailDto.isCandidateResponded());
            return candidateDetailRepository.save(candidateDetail.get());
        } else {
            throw new CandidateServiceException(ErrorType.CANDIDATEDETAIL_NOT_FOUND);
        }
    }

    public Boolean delete(DeleteCandidateDetailDto deleteCandidateDetailDto) {
        Optional<CandidateDetail> candidateDetail = candidateDetailRepository
                .findOptionalById(deleteCandidateDetailDto.getId());
        if (candidateDetail.isPresent()) {
            delete(candidateDetail.get());
            return true;
        } else {
            throw new CandidateServiceException(ErrorType.CANDIDATEDETAIL_NOT_FOUND);
        }
    }

    public List<CandidateDetail> findAll() {
        return candidateDetailRepository.findAll();
    }

    public CandidateDetail getById(Long id) {
        Optional<CandidateDetail> candidateDetail = candidateDetailRepository.findById(id);
        if (candidateDetail.isPresent()) {
            return candidateDetail.get();
        } else {
            throw new CandidateServiceException(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }
}