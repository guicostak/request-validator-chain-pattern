package com.example.validator.validator;

import com.example.validator.domain.model.Violacao;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain<T> {

    private final List<Validator<T>> validators = new ArrayList<>();


    public void addValidator(Validator<T> validador) {
        validators.add(validador);
    }

    public List<Violacao> validar(T objeto) {

        List<Violacao> violacoes = new ArrayList<>();
        validators.forEach(validator -> validator.validate(objeto, violacoes));

        return violacoes;
    }
}

