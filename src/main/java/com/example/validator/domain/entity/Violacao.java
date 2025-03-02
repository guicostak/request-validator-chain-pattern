package com.example.validator.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Violacao {

    @JsonProperty
    private String campo;

    @JsonProperty
    private String mensagem;
}
