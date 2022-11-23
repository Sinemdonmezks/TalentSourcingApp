package com.sinem.repository.entity;

import com.sinem.repository.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.sinem.repository.entity.enums.Status.SOURCED;

@Table(name= "tblcandidate")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSurname;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = SOURCED;
    @Builder.Default
    private long date = System.currentTimeMillis();

}
