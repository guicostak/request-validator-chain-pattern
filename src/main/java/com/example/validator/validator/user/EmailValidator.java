package com.example.validator.validator.user;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.entity.Violacao;
import com.example.validator.validator.Validator;

import java.util.List;

public class EmailValidator implements Validator<UserRequestDto> {

    @Override
    public void validate(UserRequestDto usuario, List<Violacao> violacoes) {
        if (usuario.getEmail() == null || !usuario.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            violacoes.add(new Violacao("email", "Email inválido."));
        }
    }
}