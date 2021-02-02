package com.kwon770.lamt.domain.todo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    private String user;

    @Column(nullable = false)
    private Boolean isCompleted;

    private String closingDate;

    private String closingTime;

    @Column(nullable = false)
    private Integer priority;

    @Builder
    public Todo(String user) {
        this.title = "Todo";
        this.user = user;
        this.isCompleted = false;
        this.closingDate = LocalDate.now().toString();
        DateTimeFormatter tFormatter = DateTimeFormatter.ofPattern("HH:mm");
        this.closingTime = LocalTime.now().format(tFormatter);
        this.priority = 1;
    }

    public Todo update(String title, String closingDate, String closingTime, Integer priority) {
        this.title = title;
        this.closingDate = closingDate;
        this.closingTime = closingTime;
        this.priority = priority;
        return this;
    }
}
