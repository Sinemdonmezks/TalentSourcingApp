package com.sinem.service;

import com.sinem.dto.request.SaveCandidateDto;
import com.sinem.dto.request.UpdateCandidateDto;
import com.sinem.exception.CandidateServiceException;
import com.sinem.exception.ErrorType;
import com.sinem.mapper.ICandidateMapper;
import com.sinem.repository.ICandidateDetailRepository;
import com.sinem.repository.ICandidateRepository;
import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.CandidateDetail;
import com.sinem.repository.entity.enums.Status;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService extends ServiceManager<Candidate, Long> {
    private final ICandidateRepository candidateRepository;
    private final ICandidateDetailRepository candidateDetailRepository;
    private final CandidateDetailService candidateDetailService;

    public CandidateService(ICandidateRepository candidateRepository,
                            CandidateDetailService candidateDetailService,
                            ICandidateDetailRepository candidateDetailRepository) {
        super(candidateRepository);
        this.candidateRepository = candidateRepository;
        this.candidateDetailService = candidateDetailService;
        this.candidateDetailRepository = candidateDetailRepository;
    }

    public Candidate save(SaveCandidateDto saveCandidateDto) {
        Candidate candidate = ICandidateMapper.INSTANCE.toCandidate(saveCandidateDto);
        save(candidate);
        CandidateDetail candidateDetail= CandidateDetail.builder()
                .candidateId(candidate.getId())
                .build();
        candidateDetailService.save(candidateDetail);
        return candidate;
    }

    public Candidate update2(UpdateCandidateDto updateCandidateDto) {
        Candidate candidateUpdate= ICandidateMapper.INSTANCE.toCandidate(updateCandidateDto);
        Optional<Candidate> candidate = candidateRepository.findOptionalById(candidateUpdate.getId());
        if (candidate.isPresent()) {
            candidate.get().setNameSurname(candidateUpdate.getNameSurname());
            candidate.get().setPhone(candidateUpdate.getPhone());
            candidate.get().setEmail(candidateUpdate.getEmail());
            candidate.get().setStatus(candidateUpdate.getStatus());
            candidateRepository.save(candidate.get());
            return candidate.get();
        } else {
            throw new CandidateServiceException(ErrorType.NOT_UPDATE);
        }

    }

    public Boolean deleteCandidate(Long id) {

        Optional<Candidate> candidate=candidateRepository.findOptionalById(id);
        Optional<CandidateDetail> candidateDetail= candidateDetailRepository.findOptionalByCandidateId(id);
        if (candidate.isPresent()){
            System.out.println("candidate"+candidate);
            delete(candidate.get());

           // candidateDetailRepository.delete(candidateDetail.get());
            return true;
        } else {
            throw new
                    CandidateServiceException(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate getById(Long id){
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if(candidate.isPresent()){
            return candidate.get();
        }else {
            throw new CandidateServiceException(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }

    public Status getByStatus(Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
            if(candidate.isPresent()){
               return candidate.get().getStatus();
            }else{
                throw new CandidateServiceException(ErrorType.CANDIDATE_NOT_FOUND);

            }
    }
}