package com.example.schedule.service;

import com.example.schedule.dto.todo.TodoResponseDto;
import com.example.schedule.dto.todo.TodoWithIdDto;
import com.example.schedule.entity.Todo;
import com.example.schedule.entity.User;
import com.example.schedule.repository.TodoRepository;
import com.example.schedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository TodoRepository;

   // 생성
   public TodoResponseDto save( String title, String contents, Long id) {

       User findUser = userRepository.findByIdOrElseThrow(id);

       Todo todo = new Todo(title, contents);
       todo.setUser(findUser);

       TodoRepository.save(todo); // DB에 저장
//      TodoResponseDto.toDto(todo)
       todo = TodoRepository.save(todo); // 저장한 객체 불러오기

       return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(),todo.getCreated());
   }

    //조회
    public List<TodoResponseDto> findAll() {
        return TodoRepository.findAll().stream()
                .map(TodoResponseDto::toDto)
                .toList();
    }


    //수정
    @Transactional
    public TodoWithIdDto update(Long id , String title, String contents) {

            Todo findTodo = TodoRepository.findByIdOrElseThrow(id);

            return new TodoWithIdDto(findTodo.getTitle(),findTodo.getContents());

    }


    //삭제
    public void delete(Long id) {

        Todo findTodo = TodoRepository.findByIdOrElseThrow(id);

        TodoRepository.delete(findTodo);
    }


}
