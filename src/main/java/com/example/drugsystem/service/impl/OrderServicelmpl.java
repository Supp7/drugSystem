package com.example.drugsystem.service.impl;

import com.example.drugsystem.mapper.OrderMapper;
import com.example.drugsystem.pojo.Order;
import com.example.drugsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicelmpl implements OrderService {

    @Autowired
    private  OrderMapper orderMapper;

    @Override
    public String addOrder(String name,double finalPrice) {
        orderMapper.addOrder(name,finalPrice);
        return "插入成功！" ;
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }
}
