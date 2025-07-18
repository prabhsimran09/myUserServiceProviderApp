package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ServiceProvider {

    @Id
    @GeneratedValue
    private Long serviceProviderID;
    private String serviceProviderName;

    @Override
    public String toString() {
        return "{" +
                "serviceProviderID=" + serviceProviderID +
                ", serviceProviderName='" + serviceProviderName + '\'' +
                '}';
    }
}
