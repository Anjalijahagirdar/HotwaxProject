package com.springrest.springrest.controller;

import com.springrest.springrest.model.Order_Header;
import com.springrest.springrest.model.Order_Item;
import com.springrest.springrest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order_Header> createOrder(@RequestBody Order_Header order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order_Header> getOrder(@PathVariable Integer orderId) {
        Optional<Order_Header> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order_Header> updateOrder(@PathVariable Integer orderId, @RequestBody Order_Header updatedOrder) {
        Optional<Order_Header> existingOrder = orderService.getOrderById(orderId);
        
        if (existingOrder.isPresent()) {
            updatedOrder.setOrder_id(orderId);  
            orderService.createOrder(updatedOrder);  
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        Optional<Order_Header> order = orderService.getOrderById(orderId);
        
        if (order.isPresent()) {
            orderService.deleteOrder(orderId);  
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Order_Item> addOrderItem(@PathVariable Integer orderId, @RequestBody Order_Item item) {
        Optional<Order_Header> order = orderService.getOrderById(orderId);
        
        if (order.isPresent()) {
            item.setOrder(order.get());  
            Order_Item createdItem = orderService.addOrderItem(item);  
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Integer orderId, @PathVariable Integer itemId) {
        Optional<Order_Header> order = orderService.getOrderById(orderId);
        
        if (order.isPresent()) {
            orderService.deleteOrderItem(itemId); 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
