package com.springrest.springrest.service;

import com.springrest.springrest.model.Order_Header;
import com.springrest.springrest.model.Order_Item;
import com.springrest.springrest.repository.OrderHeaderRepository;
import com.springrest.springrest.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order_Header createOrder(Order_Header order) {
        return orderHeaderRepository.save(order);
    }

    public Optional<Order_Header> getOrderById(Integer id) {
        return orderHeaderRepository.findById(id);
    }

    public void deleteOrder(Integer id) {
        orderHeaderRepository.deleteById(id);
    }

    public Order_Item addOrderItem(Order_Item item) {
        return orderItemRepository.save(item);
    }

    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }
}
