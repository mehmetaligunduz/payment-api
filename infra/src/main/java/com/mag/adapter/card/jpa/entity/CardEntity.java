package com.mag.adapter.card.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class CardEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_key", nullable = false)
    private String userKey;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "last_four_digit", nullable = false)
    private String lastFourDigit;

    @Column(name = "alias", nullable = false)
    private String alias;

}
