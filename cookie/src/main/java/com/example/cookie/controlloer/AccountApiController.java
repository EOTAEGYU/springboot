package com.example.cookie.controlloer;

import com.example.cookie.model.LoginRequest;
import com.example.cookie.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse){
        System.out.println(loginRequest);
        System.out.println(httpServletResponse);
        userService.login(loginRequest, httpServletResponse);
    }
}
