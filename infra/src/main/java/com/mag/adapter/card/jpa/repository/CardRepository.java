package com.mag.adapter.card.jpa.repository;

import com.mag.adapter.card.jpa.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    @Modifying
    @Query("update CardEntity c " +
            "set c.status = com.mag.adapter.card.jpa.entity.CardStatus.DELETED " +
            "where c.id = :cardId")
    void updateById(@Param("cardId") Long cardId);

}
