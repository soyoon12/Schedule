package com.example.schedule.dto.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter

public class LoginRequestDto {

    @NotNull
    private final String userName;

    @NotNull
    private final String password;

    public LoginRequestDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
