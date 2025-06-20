package com.finteka.profile.domain.valueobjects;

import java.util.Objects;

public class UserName {
    private final String value;

    public UserName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("User name cannot be null or blank");
        }
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserName)) return false;
        UserName userName = (UserName) o;
        return value.equals(userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}