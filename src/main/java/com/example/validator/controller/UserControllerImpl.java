package com.example.validator.controller;

import com.example.validator.domain.dto.UserRequestDto;
import com.example.validator.exception.ValidatorException;
import com.example.validator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserControllerImpl {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> insertUser(@RequestBody UserRequestDto requestDto) {
        try {
            return ResponseEntity.ok().body(userService.insertUser(requestDto));
        } catch (ValidatorException ex){
            return ResponseEntity.badRequest().body(ex.getError());
        }
    }
}
