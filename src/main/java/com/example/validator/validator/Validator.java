package com.example.validator.validator;

import com.example.validator.domain.entity.Violacao;

import java.util.List;

public interface Validator<T> {
    void validate(T objeto, List<Violacao> violacoes);
}
