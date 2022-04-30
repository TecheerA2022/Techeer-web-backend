package com.dev.backend.domain.user;

public enum Role {
    ADMIN(1), USER(2), GUEST(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }
}
