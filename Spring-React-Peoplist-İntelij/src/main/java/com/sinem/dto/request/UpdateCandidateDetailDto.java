package com.sinem.dto.request;

import com.sinem.repository.entity.CandidateDetail;
import com.sinem.repository.entity.enums.Status;
import com.sinem.repository.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCandidateDetailDto {
  Long candidateId;
  String content;
  String date;
  Type type;
  boolean candidateResponded;
}
