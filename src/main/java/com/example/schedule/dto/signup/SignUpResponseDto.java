package com.example.schedule.dto.signup;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String username;

    private final Long id;

    private final String email;

    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email=email;
    }
}
