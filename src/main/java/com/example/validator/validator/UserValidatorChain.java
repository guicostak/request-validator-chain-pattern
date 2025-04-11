package com.example.validator.validator;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.model.Violation;
import com.example.validator.utils.RegexUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidatorChain {

    private final List<Violation> violations = new ArrayList<>();

    public UserValidatorChain validateName(UserRequestDto user){
        if (user.nome() == null || user.nome().trim().isEmpty()) {
            violations.add(new Violation("nome", "O nome não pode estar vazio."));
        }

        return this;
    }

    public UserValidatorChain validateEmail(UserRequestDto user){
        if (user.email() == null) {
            violations.add(new Violation("email", "Email nulo."));
        } else if(!RegexUtils.isEmailValid(user.email())) {
            violations.add(new Violation("email", "Email com formato inválido."));
        }

        return this;
    }

    public List<Violation> build(){
        return this.violations;
    }
}

