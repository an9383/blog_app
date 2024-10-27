package org.sb0907.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.sb0907.blogapp.domain.User;
import org.sb0907.blogapp.dto.AddUserRequest;
import org.sb0907.blogapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;  //패스워드를 암호화 해주는 클래스
    // 회원정보 추가 메서드
    public Long save(AddUserRequest dto) {
        return userRepository.save(
                User.builder().email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    //JWT 토큰- 리플레시 토큰을 받아서 토큰 제공자를 사용하여 새로운 엑세스 토큰을 생성하는 메서드
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
