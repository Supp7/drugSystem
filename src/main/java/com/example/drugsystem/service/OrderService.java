package com.example.drugsystem.service;

import com.example.drugsystem.pojo.Order;

import java.util.List;

public interface OrderService {

    String addOrder(String name,double finalPrice);

    List<Order> findAllOrder();
}
