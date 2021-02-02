package com.kwon770.lamt.web;


import com.kwon770.lamt.domain.user.User;
import com.kwon770.lamt.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RankApiController {

    private final UserRepository userRepository;

    @GetMapping("/api/v1/rank")
    public List<User> getTop10ByOrderByScoreDesc() {
        return userRepository.getTop10ByOrderByScoreDesc();
    }
}
