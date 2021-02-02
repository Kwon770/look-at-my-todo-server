package com.kwon770.lamt.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByUserAndClosingDateGreaterThanEqualOrderByPriorityDesc(String user, String closingDate);

    @Transactional
    @Modifying
    @Query("UPDATE Todo SET isCompleted = true WHERE id = :id")
    void updateIsCompletedTrueById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Todo SET isCompleted = false WHERE id = :id")
    void updateIsCompletedFalseById(@Param("id") Long id);
}
