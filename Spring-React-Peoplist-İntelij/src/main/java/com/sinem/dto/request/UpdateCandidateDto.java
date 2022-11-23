package com.sinem.dto.request;

import com.sinem.repository.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCandidateDto {
  Long id;
  String nameSurname;
  Status status;
  String email;
  String phone;

}
