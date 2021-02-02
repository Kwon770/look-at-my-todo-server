package com.kwon770.lamt.web;

import com.kwon770.lamt.domain.user.User;
import com.kwon770.lamt.service.UserService;
import com.kwon770.lamt.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long create(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto);
    }

    @GetMapping("/api/v1/user/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
