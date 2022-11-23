package com.sinem.exception;

import lombok.Getter;

@Getter
public class CandidateServiceException extends RuntimeException {
    private final ErrorType errorType;

    public CandidateServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CandidateServiceException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
