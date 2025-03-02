package com.example.validator.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import com.example.validator.domain.model.Error;

@Getter
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class ValidatorException extends Exception {

    @JsonProperty
    private Error error;

    @JsonProperty
    private final String message;


    public ValidatorException(String message, Error error) {
        this.message = message;
        this.error = error;
    }

    public ValidatorException(String message) {
        this.message = message;
    }
}
