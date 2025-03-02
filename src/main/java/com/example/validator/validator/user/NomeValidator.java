package com.example.validator.validator.user;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.entity.Violacao;
import com.example.validator.validator.Validator;

import java.util.List;

public class NomeValidator implements Validator<UserRequestDto> {

    @Override
    public void validate(UserRequestDto usuario, List<Violacao> violacoes) {
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            violacoes.add(new Violacao("nome", "O nome não pode estar vazio."));
        }
    }
}
