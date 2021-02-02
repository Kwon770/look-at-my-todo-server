package com.kwon770.lamt.service;

import com.kwon770.lamt.domain.todo.Todo;
import com.kwon770.lamt.domain.todo.TodoRepository;
import com.kwon770.lamt.domain.user.UserRepository;
import com.kwon770.lamt.web.dto.TodoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String user) {
        return todoRepository.save(Todo.builder().user(user).build()).getId();
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
    public void toggle(String user, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));

        if (todo.getIsCompleted()) {
            todoRepository.updateIsCompletedFalseById(id);
            userRepository.decreaseScoreByUser(user);
        } else {
            todoRepository.updateIsCompletedTrueById(id);
            userRepository.increaseScoreByUser(user);
        }
    }

    public List<Todo> findAllByUserAndClosingDateGreaterThanEqualOrderByPriorityDesc(String user) {
        String today = LocalDate.now().toString();
        return todoRepository.findAllByUserAndClosingDateGreaterThanEqualOrderByPriorityDesc(user, today);
    }
}
