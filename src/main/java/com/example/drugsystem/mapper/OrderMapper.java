package com.example.drugsystem.mapper;

import com.example.drugsystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

   void addOrder(String name,double finalPrice);

   List<Order> findAllOrder();

   void chargebackById(int id);
}
