package com.example.schedule.contorller;


import com.example.schedule.common.Const;
import com.example.schedule.dto.login.LoginRequestDto;
import com.example.schedule.dto.login.LoginResponseDto;
import com.example.schedule.dto.user.UserResponseDto;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SessionUserController {

    private final UserService userService;

    @PostMapping("/session-login")
    public String login(
            @ModelAttribute LoginRequestDto dto,
            HttpServletRequest request
            ) {

        LoginResponseDto responseDto = userService.login(dto.getUserName(), dto.getPassword());
        Long userId = responseDto.getId();

        if (userId != null) {
            return "session-login";
        }

        HttpSession session = request.getSession();
        //유저 정보 불러오기
        UserResponseDto loginUser = userService.findById(userId);
        //Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, loginUser);

    }



}
