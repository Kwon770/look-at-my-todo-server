package com.kwon770.lamt.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    List<User> getTop10ByOrderByScoreDesc();

    @Transactional
    @Modifying
    @Query("UPDATE User SET score = score + 1 WHERE name = :name")
    void increaseScoreByUser(@Param("name") String user);

    @Transactional
    @Modifying
    @Query("UPDATE User SET score = score - 1 WHERE name = :name")
    void decreaseScoreByUser(@Param("name") String user);
}
