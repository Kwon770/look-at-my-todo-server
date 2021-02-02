package com.kwon770.lamt.web;

import com.kwon770.lamt.domain.todo.Todo;
import com.kwon770.lamt.service.TodoService;
import com.kwon770.lamt.web.dto.TodoCreateRequestDto;
import com.kwon770.lamt.web.dto.TodoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo/{author}/create")
    public Long create(@PathVariable String author) {
        return todoService.save(author);
    }

    @PutMapping("/api/v1/todo/{author}/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/todo/{author}/{id}")
    public Long delete(@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }

    @PatchMapping("/api/v1/todo/{author}/{id}/toggle")
    public Long toggle(@PathVariable String author, @PathVariable Long id) {
        todoService.toggle(author, id);
        return id;
    }

    @GetMapping("/api/v1/todo/{author}")
    public List<Todo> findAllByAuthorOrderByPriorityDesc(@PathVariable String author) {
        return todoService.findAllByAuthorOrderByPriorityDesc(author);
    }
}
