package com.finteka.profile.domain.entities;

import com.finteka.profile.domain.valueobjects.UserName;

public class UserProfile {
    private Long id;
    private UserName name;
    private String email;

    public UserProfile(Long id, UserName name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public UserName getName() { return name; }
    public String getEmail() { return email; }

    public void setName(UserName name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}