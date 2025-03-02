package com.example.validator.validator;

import com.example.validator.domain.model.Violacao;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain<T> {

    private final List<Validator<T>> validadores = new ArrayList<>();


    public void adicionarValidador(Validator<T> validador) {
        validadores.add(validador);
    }

    public List<Violacao> validar(T objeto) {
        List<Violacao> violacoes = new ArrayList<>();
        validadores.forEach(validador -> validador.validate(objeto, violacoes));

        return violacoes;
    }
}

