package com.example.validator.exception;

import com.example.validator.domain.entity.Violacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ValidatorException extends RuntimeException {

    @JsonProperty
    private final List<Violacao> violacoes;

    public ValidatorException(String title, List<Violacao> violacoes) {
        super(title);
        this.violacoes = violacoes;
    }
}
