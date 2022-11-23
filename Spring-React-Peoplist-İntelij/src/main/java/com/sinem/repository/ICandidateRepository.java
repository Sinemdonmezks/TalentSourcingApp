package com.sinem.repository;

import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.CandidateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findOptionalById(Long id);
    Optional<Candidate> findOptionalByEmail(String email);

}
