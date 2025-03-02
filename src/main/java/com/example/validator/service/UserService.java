package com.example.validator.service;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.domain.entity.UserEntity;
import com.example.validator.domain.model.Error;
import com.example.validator.domain.model.Violacao;
import com.example.validator.exception.ValidatorException;
import com.example.validator.validator.ValidatorChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final ValidatorChain<UserRequestDto> userRequestDtoValidatorChain;

    public UserEntity insertUser(UserRequestDto requestDto) throws ValidatorException {
        validateRequest(requestDto);

        return UserEntity.builder().build();
    }

    public void validateRequest(UserRequestDto requestDto) throws ValidatorException {
        List<Violacao> violacoes = userRequestDtoValidatorChain.validar(requestDto);

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
