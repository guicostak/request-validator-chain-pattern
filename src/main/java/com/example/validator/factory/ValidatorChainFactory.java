package com.example.validator.factory;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.validator.ValidatorChain;
import com.example.validator.validator.user.EmailValidator;
import com.example.validator.validator.user.NomeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorChainFactory {

    @Bean
    public ValidatorChain<UserRequestDto> userValidatorChain() {
        ValidatorChain<UserRequestDto> validatorChain = new ValidatorChain<>();
        validatorChain.adicionarValidador(new NomeValidator());
        validatorChain.adicionarValidador(new EmailValidator());
        return validatorChain;
    }
}
