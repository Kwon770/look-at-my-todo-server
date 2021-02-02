package com.kwon770.lamt.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("UPDATE User SET score = score + 1 WHERE name = :name")
    void increaseScoreByAuthor(@Param("name") String author);

    @Query("UPDATE User SET score = score - 1 WHERE name = :name")
    void decreaseScoreByAuthor(@Param("name") String author);
}
