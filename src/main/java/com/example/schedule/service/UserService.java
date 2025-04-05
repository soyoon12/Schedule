package com.example.schedule.service;

import com.example.schedule.dto.login.LoginResponseDto;
import com.example.schedule.dto.signup.SignUpResponseDto;
import com.example.schedule.dto.user.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //생성
    public SignUpResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email );

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
    //조회
    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        // NPE 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지않는 회원입니다 = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto( findUser.getId(), findUser.getEmail());
    }
    //수정
    @Transactional // DB쪽 수정 -> 트랜잭션을 쓰면 롤백을 시켜주는 기능
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);
    }
    //삭제
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다 " + id);
        } // global exception handler
        User findUser = optionalUser.get();

        userRepository.delete(findUser);

    }

    public LoginResponseDto login(String userName, String password) {
    }
//    //AUTH
//    public LoginResponseDto login(String userName, String password) {
//
//
//    }


}