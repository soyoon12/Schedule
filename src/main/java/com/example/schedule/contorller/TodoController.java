package com.example.schedule.contorller;

import com.example.schedule.dto.todo.CreateTodoRequestDto;
import com.example.schedule.dto.todo.TodoResponseDto;
import com.example.schedule.dto.todo.TodoWithIdDto;
import com.example.schedule.entity.Todo;
import com.example.schedule.entity.User;
import com.example.schedule.repository.TodoRepository;
import com.example.schedule.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoRepository todoRepository;

    //생성
    @PostMapping("")
    public ResponseEntity<TodoResponseDto> save (@RequestBody CreateTodoRequestDto requestDto){
        TodoResponseDto boardResponseDto =
                todoService.save(

                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getId()
                );
        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    //조회
    @GetMapping("")
    public ResponseEntity<List<TodoResponseDto>> findAll() {

        List<TodoResponseDto> boardResponseDtoList = todoService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    //단일조회
    @GetMapping("/{id}")
    public TodoWithIdDto findById(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        User writer = findTodo.getUsername();

        return new TodoWithIdDto(findTodo.getTitle(), findTodo.getContents());
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoWithIdDto> update(@PathVariable Long id, @RequestBody CreateTodoRequestDto requestDto) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        User writer = findTodo.getUsername();

        return new ResponseEntity<>(todoService.update(writer.getId(), requestDto.getTitle(), requestDto.getContents()), HttpStatus.OK);
    }
    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        todoService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //페이징

}
