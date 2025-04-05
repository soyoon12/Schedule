package com.example.schedule.dto.todo;

import lombok.Getter;

@Getter
public class TodoWithIdDto {

    //특정 게시글 조회 기능
    private final String title;

    private final String contents;



    public TodoWithIdDto(String title, String contents) {
        this.title = title;
        this.contents = contents;

    }
}
