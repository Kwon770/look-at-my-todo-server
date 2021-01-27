package com.sckwon770.project.lookatmytodo.web.dto;

import com.sckwon770.project.lookatmytodo.domain.todo.Todo;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class TodoResponseDto {

    private Long id;
    private String title;
    private String author;
    private Boolean isCompleted;
    private LocalDate closingDate;
    private LocalTime closingTime;
    private Integer priority;

    public TodoResponseDto(Todo entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.isCompleted = entity.getIsCompleted();
        this.closingDate = entity.getClosingDate();
        this.closingTime = entity.getClosingTime();
        this.priority = entity.getPriority();
    }
}
