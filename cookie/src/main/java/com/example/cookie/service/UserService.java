package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){

        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();
        // System.out.println(id);
        // System.out.println(pw);

        var optionalUser = userRepository.findByName(id);
        System.out.println(optionalUser);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();
            // System.out.println(userDto);
            if(userDto.getPassword().equals(pw)){
                var cookie = new Cookie("authorization-cookie",userDto.getId());
                cookie.setDomain("localhost"); // naver.com, daum.net
                cookie.setPath("/"); // 특정 도메인에서만 사용하겠다.
                cookie.setMaxAge(-1); // 연결된 동안만 사용하겠다. 시간도 지정 가능
                // System.out.println(cookie);
                httpServletResponse.addCookie(cookie); // 쿠키 추가 가능
            }
        }else{
            throw new RuntimeException("User Not Found");
        }
    }

}
