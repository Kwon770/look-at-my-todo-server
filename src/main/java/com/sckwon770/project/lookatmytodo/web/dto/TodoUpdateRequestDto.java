package com.sckwon770.project.lookatmytodo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequestDto {

    private String title;
    private Boolean isCompleted;
    private String closingDate;
    private String closingTime;
    private Integer priority;

    @Builder
    public TodoUpdateRequestDto(String title, Boolean isCompleted, String closingDate,
                                String closingTime, Integer priority) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.closingDate = closingDate;
        this.closingTime = closingTime;
        this.priority = priority;
    }
}
