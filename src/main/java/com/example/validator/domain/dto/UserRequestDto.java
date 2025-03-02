package com.example.validator.domain.dto;

import java.time.LocalDate;

public record UserRequestDto(String nome, String email, LocalDate dataNascimento) {
}
