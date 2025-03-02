package com.example.validator.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDto {

    private String nome;
    private String email;
    private LocalDate dataNascimento;
}
