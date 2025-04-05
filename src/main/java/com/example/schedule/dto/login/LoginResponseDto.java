package com.example.schedule.dto.login;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class LoginResponseDto {
    @NotNull
    private final Long id;
    @NotNull
    private final String userName;

    @NotNull
    private final String password;


    public LoginResponseDto(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
