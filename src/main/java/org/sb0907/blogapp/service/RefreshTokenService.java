package org.sb0907.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.sb0907.blogapp.domain.RefreshToken;
import org.sb0907.blogapp.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    // 리플레시 토큰을 전달받아서 토큰객체를 검색하여 리턴하는 역할을 담당
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}

