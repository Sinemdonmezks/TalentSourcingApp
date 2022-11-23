package com.sinem.controller;

import com.sinem.dto.request.*;
import com.sinem.repository.entity.CandidateDetail;
import com.sinem.service.CandidateDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.sinem.constant.EndPoint.*;

@RestController
 @RequestMapping(CANDIDATEDETAIL)
 @RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CandidateDetailController {
    private final CandidateDetailService candidateDetailService;

    @PostMapping(SAVE)
    public ResponseEntity<CandidateDetail> save(@RequestBody @Valid SaveCandidateDetailDto saveCandidateDetailDto) {
        return ResponseEntity.ok(candidateDetailService.save(saveCandidateDetailDto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<CandidateDetail> update(@RequestBody @Valid UpdateCandidateDetailDto updateCandidateDetailDto) {
        return ResponseEntity.ok(candidateDetailService.update(updateCandidateDetailDto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<CandidateDetail>> findAll() {
        return ResponseEntity.ok(candidateDetailService.findAll());
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteCandidate(@RequestBody DeleteCandidateDetailDto deleteCandidateDetailDto) {
        return ResponseEntity.ok(candidateDetailService.delete(deleteCandidateDetailDto));

    }
    @GetMapping(FINDBYID)
    public ResponseEntity<CandidateDetail> getById( @PathVariable Long id) {
        return ResponseEntity.ok(candidateDetailService.getById(id));
    }
}
