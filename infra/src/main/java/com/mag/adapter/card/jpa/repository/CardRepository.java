package com.mag.adapter.card.jpa.repository;

import com.mag.adapter.card.jpa.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    void deleteByUserKeyAndToken(String userKey, String token);

}
