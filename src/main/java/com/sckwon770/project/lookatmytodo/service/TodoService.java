package com.sckwon770.project.lookatmytodo.service;

import com.sckwon770.project.lookatmytodo.domain.todo.Todo;
import com.sckwon770.project.lookatmytodo.domain.todo.TodoRepository;
import com.sckwon770.project.lookatmytodo.web.dto.TodoResponseDto;
import com.sckwon770.project.lookatmytodo.web.dto.TodoUpdateRequestDto;
import com.sckwon770.project.lookatmytodo.web.dto.TodoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long save(String author, TodoSaveRequestDto requestDto) {
        return todoRepository.save(requestDto.toEntity(author)).getId();
    }

    @Transactional
    public Long update(Long id, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));

        todo.update(requestDto.getTitle(), requestDto.getIsCompleted(),
                requestDto.getClosingDate(), requestDto.getClosingTime(),
                requestDto.getPriority());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Todo entity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such Todo exists. id=" + id));

        todoRepository.delete(entity);
    }

    public List<TodoResponseDto> findAllByAuthorOrderByPriorityDesc(String author) {
        List<Todo> entityList = Optional.ofNullable(todoRepository.findAllByAuthorOrderByPriorityDesc(author))
                .orElseThrow(() -> new IllegalArgumentException("No such User exists. user=" + author));

        List<TodoResponseDto> responseDtoList = new ArrayList<>();
        entityList.forEach((entitiy) -> {
            responseDtoList.add(new TodoResponseDto(entitiy));
        });

        return responseDtoList;
    }
}
