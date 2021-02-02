package com.kwon770.lamt.web.dto;

import com.kwon770.lamt.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequestDto {
    public Todo toEntity(String author) {
        return Todo.builder()
                .author(author)
                .build();
    }
}
