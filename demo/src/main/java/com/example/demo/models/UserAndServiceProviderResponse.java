package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAndServiceProviderResponse {

    private String userId;
    private String name;
    private String type;

    public UserAndServiceProviderResponse(String userId, String name, String type) {
        this.userId = userId;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
