package com.example.schedule.dto.signup;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
public class SignUpRequestDto {

    //ㅑㅇ
    private final String username;

    private final String password;

    private final String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}