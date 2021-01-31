package com.kwon770.lamt.domain.user;

import com.kwon770.lamt.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer score;

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.score = 0;
    }

    public User update(String name, String email) {
        this.name = name;

        return this;
    }
}