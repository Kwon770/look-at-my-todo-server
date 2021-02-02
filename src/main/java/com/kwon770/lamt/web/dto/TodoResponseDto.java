package com.kwon770.lamt.web.dto;

import com.kwon770.lamt.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class TodoResponseDto {

    private Long id;
    private String title;
    private Boolean isCompleted;
    private LocalDate closingDate;
    private LocalTime closingTime;
    private Integer priority;

    public TodoResponseDto(Todo entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.isCompleted = entity.getIsCompleted();
        this.closingDate = entity.getClosingDate();
        this.closingTime = entity.getClosingTime();
        this.priority = entity.getPriority();
    }
}
