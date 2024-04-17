package com.mincheol.basic.entity;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.AllArgsConstructor;

// QAuth2.0 인증에 사용되는 유저에 대한 정보를 받는 인스턴스를 생성하는 클래스
// OAuth2User 인터페이스를 구현하여 작성해야함

@AllArgsConstructor

public class CustomOAuth2User implements OAuth2User {

    private String name;
    private Map<String, Object> Attributes;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Map<String, Object> getAttributes() {
        return this.Attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

}
