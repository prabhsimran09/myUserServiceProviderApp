package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @GeneratedValue
    @Id
    private Long userID;
    private String userName;

    @Override
    public String toString() {
        return "{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                '}';
    }
}
