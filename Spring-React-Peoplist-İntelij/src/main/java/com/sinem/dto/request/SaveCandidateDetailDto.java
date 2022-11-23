package com.sinem.dto.request;

import com.sinem.repository.entity.CandidateDetail;
import com.sinem.repository.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCandidateDetailDto {
 Long id;
 Long candidateId;
 String email;
 String content;
 boolean candidateResponded;
 String date;
 Type type;
}
