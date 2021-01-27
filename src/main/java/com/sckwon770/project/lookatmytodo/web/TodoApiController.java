package com.sckwon770.project.lookatmytodo.web;

import com.sckwon770.project.lookatmytodo.domain.todo.TodoRepository;
import com.sckwon770.project.lookatmytodo.service.TodoService;
import com.sckwon770.project.lookatmytodo.web.dto.TodoResponseDto;
import com.sckwon770.project.lookatmytodo.web.dto.TodoSaveRequestDto;
import com.sckwon770.project.lookatmytodo.web.dto.TodoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo/{author}")
    public Long save(@PathVariable String author, @RequestBody TodoSaveRequestDto requestDto) {
        return todoService.save(author, requestDto);
    }

    @PutMapping("/api/v1/todo/{author}/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @PostMapping("/api/v1/todo/{author}")
    public List<TodoResponseDto> findAllByAuthorOrderByPriorityDesc(@PathVariable String author) {
        return todoService.findAllByAuthorOrderByPriorityDesc(author);
    }

    @DeleteMapping("/api/v1/todo/{author}/{id}")
    public Long delete(@@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }
}
