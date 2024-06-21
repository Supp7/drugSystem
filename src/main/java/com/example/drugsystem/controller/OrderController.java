package com.example.drugsystem.controller;

import com.example.drugsystem.pojo.Order;
import com.example.drugsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order){
        System.out.println(order.getName()+order.getFinalPrice());
        return orderService.addOrder(order.getName(),order.getFinalPrice());
    }

    @GetMapping("")
    public List<Order> findAllOrder(){
        return orderService.findAllOrder();
    }

    @GetMapping("/chargeback/{id}")
    public String chargebackById(@PathVariable("id")int id){
        return orderService.chargebackById(id);
    };

}
