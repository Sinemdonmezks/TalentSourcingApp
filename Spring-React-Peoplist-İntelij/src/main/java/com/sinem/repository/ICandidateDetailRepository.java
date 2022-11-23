package com.sinem.repository;

import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.CandidateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICandidateDetailRepository extends JpaRepository<CandidateDetail, Long> {
    Optional<CandidateDetail> findOptionalById(Long id);
    Optional<CandidateDetail> findOptionalByCandidateId(Long id);




}
