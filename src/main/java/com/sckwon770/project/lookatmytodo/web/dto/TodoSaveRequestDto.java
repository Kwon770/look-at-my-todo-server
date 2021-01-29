package com.sckwon770.project.lookatmytodo.web.dto;

import com.sckwon770.project.lookatmytodo.domain.todo.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TodoSaveRequestDto {

    @Builder
    public TodoSaveRequestDto() {
    }

    public Todo toEntity(String author) {
        return Todo.builder()
                .author(author)
                .build();
    }
}
