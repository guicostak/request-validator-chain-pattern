package com.example.validator.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public class Error {

    @JsonProperty
    private String detalhe;

    @JsonProperty
    private List<Violacao> violacoes;

    @JsonProperty
    private HttpStatus httpStatus;
}
