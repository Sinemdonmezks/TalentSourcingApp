package com.sinem.repository.entity;

import com.sinem.repository.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Table(name = "tblCandidateDetail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CandidateDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long candidateId;
    private String content;
    private String date;
    @Builder.Default
    private boolean candidateResponded=false;
    @Enumerated(EnumType.STRING)
    private Type type;
}
