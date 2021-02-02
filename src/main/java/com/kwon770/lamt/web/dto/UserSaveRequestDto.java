package com.kwon770.lamt.web.dto;

import com.kwon770.lamt.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String name;
    private String email;

    @Builder
    public UserSaveRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}