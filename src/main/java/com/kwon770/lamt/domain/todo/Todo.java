package com.kwon770.lamt.domain.todo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Boolean isCompleted;

    private LocalDate closingDate;

    private LocalTime closingTime;

    @Column(nullable = false)
    private Integer priority;

    @Builder
    public Todo(String author) {
        this.title = "Todo";
        this.author = author;
        this.isCompleted = false;
        this.closingDate = LocalDate.now();
        this.closingTime = LocalTime.now();
        this.priority = 1;
    }

    public Todo update(String title, String closingDate, String closingTime, Integer priority) {
        this.title = title;
        this.closingDate = LocalDate.parse(closingDate);
        this.closingTime = LocalTime.parse(closingTime);
        this.priority = priority;
        return this;
    }
}
