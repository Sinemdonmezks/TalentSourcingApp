package com.sinem.dto.request;

import com.sinem.repository.entity.CandidateDetail;
import com.sinem.repository.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCandidateDto {
 String nameSurname;
 private String email;
 private String phone;

}
