package com.kwon770.lamt.domain;

import com.kwon770.lamt.domain.user.User;
import com.kwon770.lamt.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void test_loadingUser() {
        // given
        userRepository.save(User.builder()
        .name("sckwon770")
        .email("sckwon770@gmail.com")
        .build());

        // when
        List<User> userList = userRepository.findAll();

        // then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo("sckwon770");
        assertThat(user.getEmail()).isEqualTo("sckwon770@gmail.com");
    }
}
