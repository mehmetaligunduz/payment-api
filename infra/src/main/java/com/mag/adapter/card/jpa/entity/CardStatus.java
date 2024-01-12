package com.mag.adapter.card.jpa.entity;

public enum CardStatus {

    ACTIVE,
    PASSIVE,
    EXPIRED,
    DELETED,
    BLOCKED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
