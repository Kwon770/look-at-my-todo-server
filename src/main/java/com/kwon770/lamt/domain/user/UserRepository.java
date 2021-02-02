package com.kwon770.lamt.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE User SET score = score + 1 WHERE name = :name")
    void increaseScoreByAuthor(@Param("name") String author);

    @Transactional
    @Modifying
    @Query("UPDATE User SET score = score - 1 WHERE name = :name")
    void decreaseScoreByAuthor(@Param("name") String author);
}
