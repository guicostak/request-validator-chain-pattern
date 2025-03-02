package com.example.validator.service;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.entity.UserEntity;
import com.example.validator.domain.entity.Violacao;
import com.example.validator.exception.ValidatorException;
import com.example.validator.validator.ValidatorChain;
import com.example.validator.validator.user.EmailValidator;
import com.example.validator.validator.user.NomeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public UserEntity insertUser(UserRequestDto requestDto) throws ValidatorException {

        ValidatorChain<UserRequestDto> validadorChain = new ValidatorChain<>();
        validadorChain.adicionarValidador(new NomeValidator());
        validadorChain.adicionarValidador(new EmailValidator());

        List<Violacao> violacoes = validadorChain.validar(requestDto);

        if(!violacoes.isEmpty()) {
            throw new ValidatorException("Erro de requisição", violacoes);
        }

        return UserEntity.builder().build();
    }
}
