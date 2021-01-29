package com.sckwon770.project.lookatmytodo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("UPDATE User SET User.score = score + 1 WHERE User.name = :name")
    void addScoreByAuthor(@Param("name") String author);

    @Query("UPDATE User SET User.score = score - 1 WHERE User.name = :name")
    void subtractScoreByAuthor(@Param("name") String author);
}
