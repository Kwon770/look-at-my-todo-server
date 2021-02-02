package com.kwon770.lamt.web;

import com.kwon770.lamt.domain.todo.Todo;
import com.kwon770.lamt.service.TodoService;
import com.kwon770.lamt.web.dto.TodoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo/{user}/create")
    public Long save(@PathVariable String user) {
        return todoService.save(user);
    }

    @PutMapping("/api/v1/todo/{user}/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/todo/{user}/{id}")
    public Long delete(@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }

    @PatchMapping("/api/v1/todo/{user}/{id}/toggle")
    public Long toggle(@PathVariable String user, @PathVariable Long id) {
        todoService.toggle(user, id);
        return id;
    }

    @GetMapping("/api/v1/todo/{user}")
    public List<Todo> findAllByUserAndClosingDateGreaterThanEqualOrderByPriorityDesc(@PathVariable String user) {
        return todoService.findAllByUserAndClosingDateGreaterThanEqualOrderByPriorityDesc(user);
    }
}
