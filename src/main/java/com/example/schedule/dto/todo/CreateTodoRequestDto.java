package com.example.schedule.dto.todo;

import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    private private String title;

    private String contents;

    private Long id;



    public CreateTodoRequestDto(String title, String contents, Long id) {
        this.title = title;
        this.contents = contents;
        this.id = id;
        //cookie Seesion Token을 활용할 수 있다.
    }
}

