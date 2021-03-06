package com.kwon770.lamt.service;

import com.kwon770.lamt.domain.user.User;
import com.kwon770.lamt.domain.user.UserRepository;
import com.kwon770.lamt.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        return userRepository.save(userSaveRequestDto.toEntity()).getId();
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public Long requestLogin(UserSaveRequestDto userSaveRequestDto) {
        System.out.println(userSaveRequestDto.getName());
        System.out.println(userSaveRequestDto.getEmail());
        System.out.println(userSaveRequestDto.getPicture());
        User result = findByName(userSaveRequestDto.getName());
        if (result != null) {
            return result.getId();
        } else {
            return save(userSaveRequestDto);
        }
    }

    public List<User> getTop10ByOrderByScoreDesc() {
        return userRepository.getTop10ByOrderByScoreDesc();
    }
}
