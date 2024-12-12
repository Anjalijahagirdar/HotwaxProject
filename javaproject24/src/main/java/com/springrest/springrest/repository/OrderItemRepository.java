package com.springrest.springrest.repository;

import com.springrest.springrest.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Order_Item, Integer> {
}
