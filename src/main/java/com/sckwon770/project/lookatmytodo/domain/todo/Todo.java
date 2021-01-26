package com.sckwon770.project.lookatmytodo.domain.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean isCompleted;

    private LocalDateTime closingDate;

    private LocalDateTime closingTime;

    private Integer priority;

    private Byte periodType;

    private String detailTerm;
}
