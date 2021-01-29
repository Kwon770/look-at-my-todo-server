package com.sckwon770.project.lookatmytodo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByAuthorOrderByPriorityDesc(String author);

    @Query("UPDATE Todo SET Todo.isCompleted = true WHERE Todo.id = :id")
    void setisCompletedTrueById(@Param("id") Long id);

    @Query("UPDATE Todo SET Todo.isCompleted = false WHERE Todo.id = :id")
    void setisCompletedFalseById(@Param("id") Long id);
}
