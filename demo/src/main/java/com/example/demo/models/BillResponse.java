package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResponse {
    private String billId;

    @Override
    public String toString() {
        return "{" +
                "billId='" + billId + '\'' +
                '}';
    }
}