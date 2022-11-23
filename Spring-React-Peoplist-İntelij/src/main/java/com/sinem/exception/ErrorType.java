package com.sinem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    CITY_NOT_CREATED(1005, "Şehir ve İlçe veri tabanında mevcuttur.", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    NOT_UPDATE(2002,"Update işlemi gerçekleştirilemedi",INTERNAL_SERVER_ERROR),
    CANDIDATE_NOT_FOUND(2003,"Candidate bulunamadı" ,INTERNAL_SERVER_ERROR ),
    CANDIDATEDETAIL_NOT_FOUND(2004, "Candidate detail bulunamadı", INTERNAL_SERVER_ERROR );

    private int code;
    private String message;
    HttpStatus httpStatus;

}
