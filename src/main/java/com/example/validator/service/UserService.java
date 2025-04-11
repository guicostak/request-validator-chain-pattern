package com.example.validator.service;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.entity.UserEntity;
import com.example.validator.domain.model.Error;
import com.example.validator.domain.model.Violation;
import com.example.validator.exception.ValidatorException;
import com.example.validator.validator.UserValidatorChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final HttpClient httpClient;

    public UserEntity insertUser(UserRequestDto requestDto) throws ValidatorException {
        validateRequest(requestDto);

        return UserEntity.builder().build();
    }

    public void validateRequest(UserRequestDto requestDto) throws ValidatorException {
        List<Violation> violacoes = new UserValidatorChain()
                .validateName(requestDto)
                .validateEmail(requestDto)
                .build();

        if (!violacoes.isEmpty()) {
            throw new ValidatorException("Erro ao completar a requisição",
                    Error.builder()
                            .detalhe("Erro ao validar o corpo da requisição")
                            .violacoes(violacoes)
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .build());
        }
    }
}
