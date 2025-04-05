package com.example.schedule.dto.todo;

import com.example.schedule.entity.Todo;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final Date createdate;

    public TodoResponseDto (Long id, String title, String contents,Date createdate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdate = createdate;
    }

    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(),todo.getCreated());
    }
}
