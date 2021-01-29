package com.sckwon770.project.lookatmytodo.domain.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String author;

    @Column(nullable = false)
    private Boolean isCompleted;

    private LocalDate closingDate;

    private LocalTime closingTime;

    @Column(nullable = false)
    private Integer priority;

//    private Byte periodType;
//
//    private String detailTerm;

    @Builder
    public Todo(String author) {
        this.title = "Todo";
        this.author = author;
        this.isCompleted = false;
        this.closingDate = LocalDate.now();
        this.closingTime = LocalTime.now();
        this.priority = 1;
    }

    public void update(String title, Boolean isCompleted,
                       String closingDate, String closingTime, Integer priority) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.closingDate = LocalDate.parse(closingDate);
        this.closingTime = LocalTime.parse(closingTime);
        this.priority = priority;
    }
}
