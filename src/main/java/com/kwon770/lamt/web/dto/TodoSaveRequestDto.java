package com.kwon770.lamt.web.dto;

import com.kwon770.lamt.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequestDto {
    public Todo toEntity(String user) {
        return Todo.builder()
                .user(user)
                .build();
    }
}
