package com.sprata.myblog.service;

import com.sprata.myblog.dto.LoginRequestDto;
import com.sprata.myblog.dto.SignupRequestDto;
import com.sprata.myblog.dto.BlogResponseDto;
import com.sprata.myblog.entity.User;
import com.sprata.myblog.entity.UserRoleEnum;
import com.sprata.myblog.jwt.JwtUtil;
import com.sprata.myblog.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private static boolean LoginStatus = false;
    private final PasswordEncoder passwordEncoder;
    // ADMIN_TOKEN
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public static boolean isLoginStatus() {
        return LoginStatus;
    }

    public static void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }


    @Transactional
    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        // 회원 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        String email = signupRequestDto.getEmail();
        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (signupRequestDto.isAdmin()) {
            if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, email, role);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // 비밀번호 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername(), user.getRole()));
    }

    @Transactional(readOnly = true)
    public boolean loginGet(HttpServletResponse response) {
        return isLoginStatus();
        /*
         * response
         * http 통신시 header에 jwt 토큰방식의 헤더를 추가해서 응답 해주는 코드인가? ... ㅎ
         * 유저 아이디와 / 유저의 현재 권한을 암호화 후 토큰을 생성해주는 것이 맞는지?
         * */
    }
}
