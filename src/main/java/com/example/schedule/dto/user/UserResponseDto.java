package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    public UserResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
