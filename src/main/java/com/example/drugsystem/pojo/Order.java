package com.example.drugsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private String name;
    private double finalPrice;
    private String transactionTime;
    private int chargeback;
}
