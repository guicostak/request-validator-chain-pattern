package com.example.validator.validator.user;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.model.Violacao;
import com.example.validator.utils.RegexUtils;
import com.example.validator.validator.Validator;

import java.util.List;

public class EmailValidator implements Validator<UserRequestDto> {

    @Override
    public void validate(UserRequestDto usuario, List<Violacao> violacoes) {
        if (usuario.email() == null) {
            violacoes.add(new Violacao("email", "Email nulo."));
        } else if(!RegexUtils.isEmailValid(usuario.email())) {
            violacoes.add(new Violacao("email", "Email com formato inválido."));
        }
    }
}