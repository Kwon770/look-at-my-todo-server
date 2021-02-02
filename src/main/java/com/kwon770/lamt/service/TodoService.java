package com.kwon770.lamt.service;

import com.kwon770.lamt.domain.todo.Todo;
import com.kwon770.lamt.domain.todo.TodoRepository;
import com.kwon770.lamt.domain.user.UserRepository;
import com.kwon770.lamt.web.dto.TodoCreateRequestDto;
import com.kwon770.lamt.web.dto.TodoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String author) {
        return todoRepository.save(Todo.builder().author(author).build()).getId();
    }

    @Transactional
    public Long update(Long id, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));
        todo.update(requestDto.getTitle(), requestDto.getClosingDate(), requestDto.getClosingTime(), requestDto.getPriority());

        return todoRepository.save(todo).getId();
    }

    @Transactional
    public void delete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));

        todoRepository.delete(todo);
    }

    @Transactional
    public void toggle(String author, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));

        if (todo.getIsCompleted()) {
            todoRepository.updateIsCompletedFalseById(id);
            userRepository.decreaseScoreByAuthor(author);
        } else {
            todoRepository.updateIsCompletedTrueById(id);
            userRepository.increaseScoreByAuthor(author);
        }
    }

    public List<Todo> findAllByAuthorOrderByPriorityDesc(String author) {
        return todoRepository.findAllByAuthorOrderByPriorityDesc(author);
    }
}
