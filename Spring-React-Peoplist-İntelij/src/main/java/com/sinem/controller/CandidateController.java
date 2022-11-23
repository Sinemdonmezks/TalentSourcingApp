package com.sinem.controller;

import com.sinem.dto.request.DeleteCandidateDto;
import com.sinem.dto.request.SaveCandidateDto;
import com.sinem.dto.request.UpdateCandidateDto;
import com.sinem.dto.response.CandidateStatusResponseDto;
import com.sinem.repository.entity.Candidate;
import com.sinem.repository.entity.enums.Status;
import com.sinem.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.sinem.constant.EndPoint.*;

@RestController
@RequestMapping(CANDIDATE)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping(SAVE)
    public ResponseEntity<Candidate> save(@RequestBody @Valid SaveCandidateDto saveCandidateDto) {
        return ResponseEntity.ok(candidateService.save(saveCandidateDto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Candidate> update(@RequestBody @Valid UpdateCandidateDto updateCandidateDto) {
        return ResponseEntity.ok(candidateService.update2(updateCandidateDto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Candidate>> findAll() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteCandidate(@RequestBody @PathVariable Long id) {
        System.out.println("id...: " +id);
        return ResponseEntity.ok(candidateService.deleteCandidate(id));

    }

    @GetMapping(FINDBYID)
    public ResponseEntity<Candidate> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getById(id));
    }

    @GetMapping(GETSTATUS)
    public ResponseEntity<Status> getCandidateStatus(@RequestBody Long id) {
        return ResponseEntity.ok(candidateService.getByStatus(id));
    }

}
