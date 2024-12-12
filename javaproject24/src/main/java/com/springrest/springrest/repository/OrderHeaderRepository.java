package com.springrest.springrest.repository;

import com.springrest.springrest.model.Order_Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHeaderRepository extends JpaRepository<Order_Header, Integer> {
}
