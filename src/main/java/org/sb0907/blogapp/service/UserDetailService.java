package org.sb0907.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.sb0907.blogapp.domain.User;
import org.sb0907.blogapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor    //final키워드 사용시에는 반드시 RequiredArgsConstructor가 필요함.
@Service
public class UserDetailService implements UserDetailsService {
    // final은 반드시 RequiredArgsConstructor가 반드시 필요함.
    private final UserRepository userRepository;
    // 사용자 이름(이메일)으로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                 .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
