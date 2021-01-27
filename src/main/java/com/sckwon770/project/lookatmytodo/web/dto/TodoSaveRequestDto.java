package com.sckwon770.project.lookatmytodo.web.dto;

import com.sckwon770.project.lookatmytodo.domain.todo.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequestDto {

    private String title;

    @Builder
    public TodoSaveRequestDto(String title) {
        this.title = title;
    }

    public Todo toEntity(String author) {
        return Todo.builder()
                .title(title)
                .author(author)
                .build();
    }
}
