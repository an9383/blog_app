package org.sb0907.blogapp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")  // 엔터티와 테이블이름이 다를경우에는 사용. 데이터베이스내부에 내장되어 있는 경우가 많음
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //default 매개변수
@Getter // 파일을 읽어올때 필요함.
@Entity // Entity로 사용하겠다.
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth) {   //auth
        this.email = email;
        this.password = password;
    }
    // 권한을 반환하는 메소드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    // 인터페이스에 있는 메소드를 재정의함. 사용자의 id를 반환(고유한 값)
    @Override
    public String getUsername() {
        return email;
    }
    // 사용자 패스워드 반환
    @Override
    public String getPassword() {
        return password;
    }
    //계정이 만료여부를 반환
    //계정이 만료되지 않았느냐 --> true: 만료되지 않았음.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //계정의 잠금여부를 반환
    //계정이 잠금되지 않았느냐 -> true: 잠금되지 않았음.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 패스워드에 대해서 만료여부를 반환
    // 패스워드가 만료되지 않았느냐 -> true: 만료되지 않았음.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 사용가능여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
