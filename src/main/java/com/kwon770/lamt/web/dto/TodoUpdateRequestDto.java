package com.kwon770.lamt.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequestDto {

    private String title;
    private String closingDate;
    private String closingTime;
    private Integer priority;

    @Builder
    public TodoUpdateRequestDto(String title, String closingDate, String closingTime, Integer priority) {
        this.title = title;
        this.closingDate = closingDate;
        this.closingTime = closingTime;
        this.priority = priority;
    }
}
