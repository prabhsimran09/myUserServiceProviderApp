package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserAndServiceProviderRequest {
    private String name;
    private String type; //USER,SERVICE_PROVIDER

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

